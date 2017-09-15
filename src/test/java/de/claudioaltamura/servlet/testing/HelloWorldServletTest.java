package de.claudioaltamura.servlet.testing;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.claudioaltamura.servlet.testing.HelloWorldServlet;

@RunWith(EasyMockRunner.class)
public class HelloWorldServletTest {

	@TestSubject
	private HelloWorldServlet servlet = new HelloWorldServlet();

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		expect(response.getWriter()).andReturn(printWriter);
		replay(request, response);

		servlet.doGet(request, response);

		assertEquals("Hello World!", stringWriter.toString());

		verify(request, response);
	}

}
