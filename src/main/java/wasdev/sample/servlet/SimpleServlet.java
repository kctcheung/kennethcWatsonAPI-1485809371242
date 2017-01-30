package wasdev.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().print(translateToSpanish("This is a test"));
	}

	private String translateToSpanish(String text){

		LanguageTranslator service = new LanguageTranslator();
		service.setUsernameAndPassword("26c52d9f-b0e9-4343-a686-0dc59d4f5fda", "Cra3SDH4nG3j");
		TranslationResult translationResult = service.translate(
				text, Language.ENGLISH, Language.SPANISH)
				.execute();
		return translationResult.getFirstTranslation();
	}

}


