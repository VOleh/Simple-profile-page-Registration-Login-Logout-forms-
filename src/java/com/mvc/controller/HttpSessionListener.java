
package com.mvc.controller;

import com.mvc.bean.Chat;
import com.mvc.bean.Post;
import com.mvc.bean.User;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;


public class HttpSessionListener  implements javax.servlet.http.HttpSessionListener{
    private HttpSession httpSession;
    private  Set<Chat> listChats;
    private Map <Integer,User> usersOnline;
    private List<Post> list;

    @Override
    public void sessionCreated(HttpSessionEvent se) {        
        System.out.println("Session created: "+ se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {        
        System.out.println("Session closed: "+ se.getSession().getId());
    }
    
}
