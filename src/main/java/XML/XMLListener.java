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
	 * Enter a parse tree produced by {@link XMLParser#startv}.
	 * @param ctx the parse tree
	 */
	void enterStartv(XMLParser.StartvContext ctx);
	/**
	 * Exit a parse tree produced by {@link XMLParser#startv}.
	 * @param ctx the parse tree
	 */
	void exitStartv(XMLParser.StartvContext ctx);
	/**
	 * Enter a parse tree produced by {@link XMLParser#endv}.
	 * @param ctx the parse tree
	 */
	void enterEndv(XMLParser.EndvContext ctx);
	/**
	 * Exit a parse tree produced by {@link XMLParser#endv}.
	 * @param ctx the parse tree
	 */
	void exitEndv(XMLParser.EndvContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link XMLParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(XMLParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link XMLParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(XMLParser.ArrayContext ctx);
}