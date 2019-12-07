package XML;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

public class GenerateJson   {

    public static class JSONEmitter extends XMLBaseListener {
        String test = "";

        @Override
        public void exitValue(XMLParser.ValueContext ctx) {

          //  System.err.println(ctx.getParent().getChild(0).getText());
         //   System.out.println(ctx.getText());
          //  test += ctx.getText() + "\n";
        }

        @Override
        public void exitPair(XMLParser.PairContext ctx) {
            System.err.println(ctx.getChild(1) instanceof XMLParser.PairContext);
          System.out.println(ctx.getChild(1).getText());
        }
    }

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream(is);
        XMLLexer lexer = new XMLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XMLParser parser = new XMLParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.xml();
        // show tree in text form
        //   System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
       // XMLListener listener = new XMLListener();
        JSONEmitter converter = new JSONEmitter();
        walker.walk(converter, tree);
        System.out.println(converter.test);
    }
}
