package io.github.luansz.javafundamentals.oop;

    public enum Priority {
        CRITICAL(15),
        HIGH(30),
        MEDIUM(120),
        LOW(480);

        private final int slaMinutes;

        Priority(int slaMinutes) {
            this.slaMinutes = slaMinutes;
        }

        public int getSlaMinutes() {
            return slaMinutes;
        }
    }



