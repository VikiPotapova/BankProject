package com.potapova.bankProject.exception;

public class EmptyDirectoryException extends RuntimeException {
    private String info;

    public EmptyDirectoryException(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Empty directory exception. " + info;
    }
}
