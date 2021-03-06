/*
 * JSP generated by Resin-4.0.40 (built Fri, 16 May 2014 11:10:25 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _blog__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  private boolean _caucho_isNotModified;
  private com.caucho.jsp.PageManager _jsp_pageManager;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);

    TagState _jsp_state = null;

    try {
      _jspService(request, response, pageContext, _jsp_application, session, _jsp_state);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_pageManager.freePageContext(pageContext);
    }
  }
  
  private void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response,
              com.caucho.jsp.PageContextImpl pageContext,
              javax.servlet.ServletContext application,
              javax.servlet.http.HttpSession session,
              TagState _jsp_state)
    throws Throwable
  {
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    javax.servlet.jsp.tagext.JspTag _jsp_parent_tag = null;
    com.caucho.jsp.PageContextImpl _jsp_parentContext = pageContext;
    response.setContentType("text/html; charset=UTF-8");

    out.write(_jsp_string0, 0, _jsp_string0.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string1, 0, _jsp_string1.length);
    _caucho_expr_1.print(out, _jsp_env, false);
    out.write(_jsp_string1, 0, _jsp_string1.length);
    _caucho_expr_2.print(out, _jsp_env, false);
    out.write(_jsp_string2, 0, _jsp_string2.length);
    _caucho_expr_3.print(out, _jsp_env, false);
    out.write(_jsp_string3, 0, _jsp_string3.length);
  }

  private com.caucho.make.DependencyContainer _caucho_depends
    = new com.caucho.make.DependencyContainer();

  public java.util.ArrayList<com.caucho.vfs.Dependency> _caucho_getDependList()
  {
    return _caucho_depends.getDependencies();
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    _caucho_depends.add(depend);
  }

  protected void _caucho_setNeverModified(boolean isNotModified)
  {
    _caucho_isNotModified = true;
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;

    if (_caucho_isNotModified)
      return false;

    if (com.caucho.server.util.CauchoSystem.getVersionId() != -1387936341923620786L)
      return true;

    return _caucho_depends.isModified();
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
    TagState tagState;
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("blog.jsp"), 5130422222086648383L, false);
    _caucho_depends.add(depend);
  }

  final static class TagState {

    void release()
    {
    }
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void caucho_init(ServletConfig config)
  {
    try {
      com.caucho.server.webapp.WebApp webApp
        = (com.caucho.server.webapp.WebApp) config.getServletContext();
      init(config);
      if (com.caucho.jsp.JspManager.getCheckInterval() >= 0)
        _caucho_depends.setCheckInterval(com.caucho.jsp.JspManager.getCheckInterval());
      _jsp_pageManager = webApp.getJspApplicationContext().getPageManager();
      com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
      com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.InitPageContextImpl(webApp, this);
      _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${blog.title }");
      _caucho_expr_1 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${blog.ip }");
      _caucho_expr_2 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${blog.time }");
      _caucho_expr_3 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${blog.content }");
    } catch (Exception e) {
      throw com.caucho.config.ConfigException.create(e);
    }
  }
  private static com.caucho.el.Expr _caucho_expr_0;
  private static com.caucho.el.Expr _caucho_expr_1;
  private static com.caucho.el.Expr _caucho_expr_2;
  private static com.caucho.el.Expr _caucho_expr_3;

  private final static char []_jsp_string3;
  private final static char []_jsp_string2;
  private final static char []_jsp_string1;
  private final static char []_jsp_string0;
  static {
    _jsp_string3 = "</div>\r\n	</div>\r\n	\r\n</body>\r\n</html>".toCharArray();
    _jsp_string2 = "</div>\r\n		<div>content:</div>\r\n		<div>".toCharArray();
    _jsp_string1 = "</div>\r\n		<div>ip:".toCharArray();
    _jsp_string0 = "\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n\r\n    <title>\u7f16\u8f91\u535a\u5ba2</title>\r\n    <link href=\"umeditor/themes/default/css/umeditor.css\" type=\"text/css\" rel=\"stylesheet\">\r\n    <script type=\"text/javascript\" src=\"umeditor/third-party/jquery.min.js\"></script>\r\n    <script type=\"text/javascript\" charset=\"utf-8\" src=\"umeditor/umeditor.config.js\"></script>\r\n    <script type=\"text/javascript\" charset=\"utf-8\" src=\"umeditor/umeditor.min.js\"></script>\r\n    <script type=\"text/javascript\" src=\"umeditor/lang/zh-cn/zh-cn.js\"></script>\r\n    <style type=\"text/css\">\r\n        h1{\r\n            font-family: \"\u5fae\u8f6f\u96c5\u9ed1\";\r\n            font-weight: normal;\r\n        }\r\n        .btn {\r\n            display: inline-block;\r\n            *display: inline;\r\n            padding: 4px 12px;\r\n            margin-bottom: 0;\r\n            *margin-left: .3em;\r\n            font-size: 14px;\r\n            line-height: 20px;\r\n            color: #333333;\r\n            text-align: center;\r\n            text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);\r\n            vertical-align: middle;\r\n            cursor: pointer;\r\n            background-color: #f5f5f5;\r\n            *background-color: #e6e6e6;\r\n            background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6);\r\n            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6));\r\n            background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6);\r\n            background-image: -o-linear-gradient(top, #ffffff, #e6e6e6);\r\n            background-image: linear-gradient(to bottom, #ffffff, #e6e6e6);\r\n            background-repeat: repeat-x;\r\n            border: 1px solid #cccccc;\r\n            *border: 0;\r\n            border-color: #e6e6e6 #e6e6e6 #bfbfbf;\r\n            border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);\r\n            border-bottom-color: #b3b3b3;\r\n            -webkit-border-radius: 4px;\r\n            -moz-border-radius: 4px;\r\n            border-radius: 4px;\r\n            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff', endColorstr='#ffe6e6e6', GradientType=0);\r\n            filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);\r\n            *zoom: 1;\r\n            -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);\r\n            -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);\r\n            box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);\r\n        }\r\n\r\n        .btn:hover,\r\n        .btn:focus,\r\n        .btn:active,\r\n        .btn.active,\r\n        .btn.disabled,\r\n        .btn[disabled] {\r\n            color: #333333;\r\n            background-color: #e6e6e6;\r\n            *background-color: #d9d9d9;\r\n        }\r\n\r\n        .btn:active,\r\n        .btn.active {\r\n            background-color: #cccccc \\9;\r\n        }\r\n\r\n        .btn:first-child {\r\n            *margin-left: 0;\r\n        }\r\n\r\n        .btn:hover,\r\n        .btn:focus {\r\n            color: #333333;\r\n            text-decoration: none;\r\n            background-position: 0 -15px;\r\n            -webkit-transition: background-position 0.1s linear;\r\n            -moz-transition: background-position 0.1s linear;\r\n            -o-transition: background-position 0.1s linear;\r\n            transition: background-position 0.1s linear;\r\n        }\r\n\r\n        .btn:focus {\r\n            outline: thin dotted #333;\r\n            outline: 5px auto -webkit-focus-ring-color;\r\n            outline-offset: -2px;\r\n        }\r\n\r\n        .btn.active,\r\n        .btn:active {\r\n            background-image: none;\r\n            outline: 0;\r\n            -webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);\r\n            -moz-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);\r\n            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);\r\n        }\r\n\r\n        .btn.disabled,\r\n        .btn[disabled] {\r\n            cursor: default;\r\n            background-image: none;\r\n            opacity: 0.65;\r\n            filter: alpha(opacity=65);\r\n            -webkit-box-shadow: none;\r\n            -moz-box-shadow: none;\r\n            box-shadow: none;\r\n        }\r\n    </style>\r\n</head>\r\n<body>\r\n\r\n	<div style=\"margin: 0 auto;\">\r\n		<div>title:".toCharArray();
  }
}
