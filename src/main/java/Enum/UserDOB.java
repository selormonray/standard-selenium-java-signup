package Enum;

public enum UserDOB {

    DAY_OF_BIRTH {
        @Override
        public Integer getDropdownValue() {
            return 10;
        }
    },

    MONTH_OF_BIRTH {
        @Override
        public Integer getDropdownValue() {
            return 12;
        }
    },

    YEAR_OF_BIRTH {
        @Override
        public Integer getDropdownValue() {
            return 2015;
        }
    };

    public abstract Integer getDropdownValue();

}
