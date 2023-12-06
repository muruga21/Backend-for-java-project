import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Statement;

import Database.MySqlDB;

public class Server {

    MySqlDB Db_obj = new MySqlDB();
    Statement statement = Db_obj.Connection_method();
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(4000), 0);
        server.createContext("/addStock", new HandleAddStock());
//        server.createContext("/delete", new DeleteHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server is listening on port 4000...");
    }
    static class HandleAddStock implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello Testing";
            sendResponse(exchange, response);
        }
    }
    private static void sendResponse(HttpExchange exchange, String response) throws IOException {
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
