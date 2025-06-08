package org.scoula.ex06.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    public abstract String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
