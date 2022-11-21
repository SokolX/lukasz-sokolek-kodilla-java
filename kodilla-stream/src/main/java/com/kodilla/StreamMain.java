package com.kodilla;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.FunctionalCalculator;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        final String TEXT_TO_MODIFY = "Text To Modify";
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify(TEXT_TO_MODIFY, PoemDecoratorUtils.bigger);
        poemBeautifier.beautify(TEXT_TO_MODIFY, PoemDecoratorUtils.smaller);
        poemBeautifier.beautify(TEXT_TO_MODIFY, PoemDecoratorUtils.textBetweenABC);
        poemBeautifier.beautify(TEXT_TO_MODIFY, PoemDecoratorUtils.noSpace);
        poemBeautifier.beautify(TEXT_TO_MODIFY, PoemDecoratorUtils.repeatTen);
        poemBeautifier.beautify(TEXT_TO_MODIFY, PoemDecoratorUtils.cut);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        BookDirectory theBookDirectoryJoining = new BookDirectory();
        String theResultStringOfBooksJoining = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooksJoining);


        Forum forumUsers = new Forum();

        Map<Integer, ForumUser> users = forumUsers.getUserList().stream()
                .filter(user -> user.sex() == 'M')
                .filter(user -> user.dateOfBirth().isBefore(LocalDate.now().minusYears(20)))
                .filter(user -> user.counterOfPublishedPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::id, user -> user));

        for (Map.Entry<Integer, ForumUser> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}