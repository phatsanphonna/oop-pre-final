
public class Main {

    public static void main(String[] args) {
        BookView bookView = new BookView();
        BookService bookService = new BookService();
        BookController bookController = new BookController(bookView, bookService);

        bookController.start();
    }
}
