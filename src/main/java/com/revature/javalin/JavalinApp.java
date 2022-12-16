package com.revature.javalin;

import com.revature.exceptions.PasswordIncorrectException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.persistence.TaskDao;
import com.revature.persistence.UserDao;
import com.revature.pojos.Task;
import com.revature.pojos.User;
import com.revature.service.TaskService;
import com.revature.service.UserService;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.Set;

public class JavalinApp {
    private static Javalin app;
    private static UserService userService;
    private static TaskService taskService;

    private JavalinApp() {

    }

    public static Javalin getApp(int port) {
        if(app == null) {
            userService = new UserService(new UserDao());
            taskService = new TaskService(new TaskDao());
            init(port);
        }
        return app;
    }

    private static void init(int port) {
        app = Javalin.create()
                .start(port);

        //user resources
        app.get("/ping", JavalinApp::ping);
        app.post("/user", JavalinApp::postNewUser);
        app.get("/user", JavalinApp::getAllUsers);
        app.post("/user/auth", JavalinApp::authenticateUser);

        //task resources
        app.get("/task", JavalinApp::getTaskById);
        app.post("/task", JavalinApp::postNewTask);
        app.put("/task", JavalinApp::updateTask);
        app.delete("/task", JavalinApp::deleteTask);






    }

    public static void ping(Context ctx) {
        ctx.result("pong!");
        ctx.status(200);

    }

    public static void postNewUser(Context ctx) {
        User newUser = ctx.bodyAsClass(User.class);
        userService.registerNewUser(newUser);

        ctx.status(201);
    }

    public static void getAllUsers(Context ctx) {
        Set<User> users = userService.getAllUsers();
        ctx.json(users);
        ctx.status(200);
    }

    public static void authenticateUser(Context ctx) {
        User auth = ctx.bodyAsClass(User.class);
        try {
            userService.authenticateUser(auth.getUsername(), auth.getPassword());
        } catch(UserNotFoundException e) {
            ctx.status(401);
            ctx.result("User not found.");
        } catch(PasswordIncorrectException e) {
            ctx.status(401);
            ctx.result("Password incorrect.");

        }
    }

    public static void getTaskById(Context ctx) {
        int id = Integer.parseInt(ctx.queryParam("task_id"));
        Task task = taskService.getTask(id);

        ctx.json(task);
        ctx.status(200);
    }

    public static void postNewTask(Context ctx) {
        Task task = ctx.bodyAsClass(Task.class);
        taskService.createNewTask(task);

        ctx.status(201);
    }

    public static void updateTask(Context ctx) {
        Task task = ctx.bodyAsClass(Task.class);
        taskService.updateTask(task);

        ctx.status(201);
    }

    public static void deleteTask(Context ctx) {
        int id = Integer.parseInt(ctx.queryParam("task_id"));
        taskService.deleteTask(id);

        ctx.status(200);
    }


}
