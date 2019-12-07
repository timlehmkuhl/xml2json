// Generated from G:/InfProjekte/XML2JSON/src/main/java/XML\XML.g4 by ANTLR 4.7.2
package XML;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XMLParser}.
 */
public interface XMLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XMLParser#xml}.
	 * @param ctx the parse tree
	 */
	void enterXml(XMLParser.XmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link XMLParser#xml}.
	 * @param ctx the parse tree
	 */
	void exitXml(XMLParser.XmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link XMLParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(XMLParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link XMLParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(XMLParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link XMLParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(XMLParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link XMLParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(XMLParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link XMLParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(XMLParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link XMLParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(XMLParser.EndContext ctx);
	/**
	 * Enter a parse tree produced by {@link XMLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(XMLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link XMLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(XMLParser.ValueContext ctx);
}