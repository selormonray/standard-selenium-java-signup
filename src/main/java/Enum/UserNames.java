package Enum;

public enum UserNames {

    TOM {
        @Override
        public String getDisplayText() {
            return "Tom";
        }
    },

    SMITH {
        @Override
        public String getDisplayText() {
            return "Smith";
        }
    },

    PASSWORD {
        @Override
        public String getDisplayText() {
            return "testingWebsite";
        }
    };


    public abstract String getDisplayText();

}
