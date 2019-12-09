package XML;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class GenerateJson   {

    public static class JSONEmitter extends XMLBaseListener {
        String test = "";

        STGroup templates = new STGroupFile("G:\\InfProjekte\\XML2JSON\\src\\main\\java\\JSON.stg");
        ST all = templates.getInstanceOf("all");
        List<String> names = new LinkedList<>();

        @Override
        public void exitValue(XMLParser.ValueContext ctx) {

          //  System.err.println(ctx.getParent().getChild(0).getText());
         //   System.out.println(ctx.getText());
          //  test += ctx.getText() + "\n";
        }

        @Override
        public void exitPair(XMLParser.PairContext ctx) {
            String name = ctx.startv().value().getText();
           if(ctx.getChild(1).getChildCount()-1 == 0 && !names.contains(name)){
               ST pair = templates.getInstanceOf("pair");
               pair.add("name", ctx.startv().value().getText()).add("content", ctx.getChild(1).getText());
               all.add("element", pair);
           } else {
           }

        }




        @Override
        public void enterArray(XMLParser.ArrayContext ctx) {

            ST pairarray = null;
           if(ctx.pair().size() > 0){
               pairarray = templates.getInstanceOf("pairarray");
           } else   {
               pairarray =  templates.getInstanceOf("emptyarray");
           }

            String name = ctx.getParent().getChild(0).getText().replace("<", "").replace(">", "");
            pairarray.add("name", name);
            int i = 0;
           for(XMLParser.PairContext pair : ctx.pair()){
               String arrayname = ctx.pair().get(i).getChild(0).getText().replace("<", "").replace(">", "");
               names.add(arrayname);
               i++;
               pairarray.add("content", pair.getChild(1).getText());

           }
            all.add("element", pairarray);
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
        System.out.println(converter.all.render());
    }
}
