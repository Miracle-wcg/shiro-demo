package com.wcg.shiro.jsqlparser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.Statements;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.util.SelectUtils;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.List;

/**
 * @Author: chengang.wu
 * @Date: 2020-04-09 14:39
 */
public class JsqlparserDemo {
    public static void main(String[] args) throws JSQLParserException {
        Statement stmt = CCJSqlParserUtil.parse("SELECT * FROM tab1 WITH (NOLOCK)");
        Statements stmts = CCJSqlParserUtil.parseStatements("SELECT * FROM tab1; SELECT * FROM tab2");

        Expression expr = CCJSqlParserUtil.parseExpression("a*(5+mycolumn)");

        Statement statement = CCJSqlParserUtil.parse("SELECT * FROM MY_TABLE1");
        Select selectStatement = (Select) statement;
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        List<String> tableList = tablesNamesFinder.getTableList(selectStatement);
        Select select = (Select) CCJSqlParserUtil.parse("select a from mytable");
        SelectUtils.addExpression(select, new Column("b"));
        System.out.println(111);
    }
}
