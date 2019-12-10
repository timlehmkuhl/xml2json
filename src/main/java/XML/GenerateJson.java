package XML;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class GenerateJson   {

    public static class JSONEmitter extends XMLBaseListener {
        String test = "";

        STGroup templates = new STGroupFile("./src/main/java/JSON.stg");
        ST all = templates.getInstanceOf("all");
        List<String> names = new LinkedList<>();



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
            ST inlay = templates.getInstanceOf("inlay");
            ST pairarray = null;
           if(ctx.pair().size() > 0){
               pairarray = templates.getInstanceOf("pairarray");
           } else   {
               pairarray =  templates.getInstanceOf("emptyarray");
           }
            boolean flag = false;
            String name = ctx.getParent().getChild(0).getText().replace("<", "").replace(">", "");
            pairarray.add("name", name);
            inlay.add("name", name);
            int i = 0;
           for(XMLParser.PairContext pair : ctx.pair()){
               String arrayname = ctx.pair().get(i).getChild(0).getText().replace("<", "").replace(">", "");
               names.add(arrayname);
               i++;
               if(!arrayname.equals("element")){
                   System.err.println(arrayname);
                   ST inlaypair = templates.getInstanceOf("inlaypair");
                   inlaypair.add("subname", arrayname).add("content", pair.getChild(1).getText());
                   flag = true;
                  inlay.add("element", inlaypair);
               } else
               pairarray.add("content", pair.getChild(1).getText());

           }
           if(flag)  all.add("element", inlay);
            else all.add("element", pairarray);
        }
    }



    public static void main(String[] args) throws Exception {
        String str = run("./src/main/resources/example.xml", "", true).render();
        System.out.println(str);
    }

    public static ST run(String file, String in, boolean isFile) throws IOException {

        CharStream input = null;
        if(isFile)
        input = CharStreams.fromFileName(file);
        else
            input = CharStreams.fromString(in);
        XMLLexer lexer = new XMLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XMLParser parser = new XMLParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.xml();
        ParseTreeWalker walker = new ParseTreeWalker();
        JSONEmitter converter = new JSONEmitter();
        walker.walk(converter, tree);
        return converter.all;
    }
}
