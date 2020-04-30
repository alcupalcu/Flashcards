public class AsciiCharSequence implements java.lang.CharSequence {

    byte[] asciiChars;

    AsciiCharSequence(byte[] asciiChars) {
        this.asciiChars = new byte[asciiChars.length];
        for(int i = 0; i < asciiChars.length; i++) {
            this.asciiChars[i] = asciiChars[i];
        }
    }

    @Override
    public int length() {
        return this.asciiChars.length;
    }

    @Override
    public char charAt(int i) {
        return (char)asciiChars[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] subArray = new byte[i1 - i];
        for(int j = i, k = 0; j < i1; j++, k++) {
            subArray[k] = this.asciiChars[j];
        }
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(subArray);
        return asciiCharSequence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < this.asciiChars.length; i++) {
            sb.append((char)this.asciiChars[i]);
        }
        String result = new String(sb);
        return result;
    }
}