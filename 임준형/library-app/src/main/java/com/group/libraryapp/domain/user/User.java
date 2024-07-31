package com.group.libraryapp.domain.user;

import static javax.persistence.GenerationType.IDENTITY;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity
public class User {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<UserLoanHistory> userLoanHistories = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Integer age;

    public User() {

    }

    public User(String name, Integer age) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다");
        }
        this.name = name;
        this.age = age;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void loanBook(Book book) {
        this.userLoanHistories.add(new UserLoanHistory(this, book.getName(), false));
    }

    public void returnBook(String bookName) {
        UserLoanHistory targetHistory = this.userLoanHistories.stream()
                .filter(history -> history.getBookName().equals(bookName))
                .findFirst()
                .orElseThrow();
        targetHistory.doReturn();
    }

    @NotNull
    public String getName() {
        return name;
    }

    @Nullable
    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

}
