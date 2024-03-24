package com.nenavizion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pager {

    private  int BUTTONS_TO_SHOW = 3;
//    static final
    private int startPage;

    private int endPage;

    public Pager(int totalPages, int currentPage, int buttonsToShow) {

        setBUTTONS_TO_SHOW(buttonsToShow);

        int halfPagesToShow = BUTTONS_TO_SHOW / 2;

        if (totalPages <= BUTTONS_TO_SHOW) {
            this.startPage = 1;
            this.endPage = totalPages;
        } else if (currentPage - halfPagesToShow <= 0) {
            this.startPage = 1;
            this.endPage = BUTTONS_TO_SHOW;
        } else if (currentPage + halfPagesToShow == totalPages) {
            this.startPage = currentPage - halfPagesToShow;
            this.endPage = totalPages;
        } else if (currentPage + halfPagesToShow > totalPages) {
            this.startPage = totalPages - BUTTONS_TO_SHOW + 1;
            this.endPage = totalPages;
        } else {
            this.startPage = currentPage - halfPagesToShow;
            this.endPage = currentPage + halfPagesToShow;
        }
    }
}