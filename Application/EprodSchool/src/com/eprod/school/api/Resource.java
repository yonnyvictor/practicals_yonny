package com.eprod.school.api;

public interface Resource {

    public static class ExceptionWrapper {
        private String error;

        public ExceptionWrapper(Exception e) {
            this.error = e.getMessage();
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}

