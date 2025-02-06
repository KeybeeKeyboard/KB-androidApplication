package it.keybeeproject.keybee.model;

/**
 * Created by c161 on 20/09/16.
 */
public class Emoji {

	private static final String TAG = Emoji.class.getSimpleName();

	private int unicode;
	private String emoji;
	private boolean isSupportedPre19;
	private boolean isSupportedPre21 = true;
	private boolean isSupportedPre22 = true;
	private boolean isSupportedPre24 = true;
	private boolean isSupportedPre26 = true;
	private boolean isSupportedPre28 = true;
	private boolean isSupportedPre29 = true;

	public static Emoji getEmojiByUnicode(int unicode, boolean isSupportedPre19){
		Emoji emoji = new Emoji(unicode, isSupportedPre19);
		emoji.emoji = newString(unicode);
		return emoji;
	}

	public static Emoji fromCodePoint(int unicode, boolean isSupportedPre19) {
		Emoji emoji = new Emoji(unicode, isSupportedPre19);
		emoji.emoji = newString(unicode);
		return emoji;
	}


	public static Emoji fromChar(char unicode, boolean isSupportedPre19) {
		Emoji emoji = new Emoji(unicode, isSupportedPre19);
		emoji.emoji = Character.toString(unicode);
		return emoji;
	}

	public static Emoji fromString(String chars, boolean isSupportedPre19) {
		Emoji emoji = new Emoji(0, isSupportedPre19);
		emoji.emoji = chars;
		return emoji;
	}

	public static Emoji fromString(String chars, boolean isSupportedPre19,boolean isSupportedPre22, boolean isSupportedPre24,boolean isSupportedPre26,boolean isSupportedPre28,boolean isSupportedPre29) {
		Emoji emoji = new Emoji(0, isSupportedPre19,isSupportedPre22,isSupportedPre24,isSupportedPre26,isSupportedPre28,isSupportedPre29);
		emoji.emoji = chars;
		return emoji;
	}

	public static Emoji fromString(String chars, boolean isSupportedPre19, boolean isSupportedPre22) {
		Emoji emoji = new Emoji(0, isSupportedPre19, isSupportedPre22);
		emoji.emoji = chars;
		return emoji;
	}

	public Emoji(int unicode, boolean isSupportedPre19) {
		this.unicode = unicode;
		this.isSupportedPre19 = isSupportedPre19;
	}

	public Emoji(int unicode, boolean isSupportedPre19, boolean isSupportedPre22) {
		this.unicode = unicode;
		this.isSupportedPre19 = isSupportedPre19;
		this.isSupportedPre22 = isSupportedPre22;
	}

	public Emoji(int unicode, boolean isSupportedPre19,boolean isSupportedPre22, boolean isSupportedPre24,boolean isSupportedPre26, boolean isSupportedPre28,boolean isSupportedPre29) {
		this.unicode = unicode;
		this.isSupportedPre19 = isSupportedPre19;
		this.isSupportedPre22 = isSupportedPre22;
		this.isSupportedPre24 = isSupportedPre24;
		this.isSupportedPre26 = isSupportedPre26;
		this.isSupportedPre28 = isSupportedPre28;
		this.isSupportedPre29 = isSupportedPre29;
	}

	public int getUnicode() {
		return unicode;
	}

	public void setUnicode(int unicode) {
		this.unicode = unicode;
	}

	public String getEmoji() {
		return emoji;
	}

	public boolean isSupportedPre19() {
		return isSupportedPre19;
	}

	public void setIsSupportedPre19(boolean isSupportedPre19) {
		this.isSupportedPre19 = isSupportedPre19;
	}

	public boolean isSupportedPre21() {
		return isSupportedPre21;
	}

	public void setSupportedPre21(boolean supportedPre21) {
		isSupportedPre21 = supportedPre21;
	}

	public boolean isSupportedPre22() {
		return isSupportedPre22;
	}
	public void setSupportedPre22(boolean supportedPre22) {
		isSupportedPre22 = supportedPre22;
	}

	public boolean isSupportedPre24() {
		return isSupportedPre24;
	}
	public void setSupportedPre24(boolean supportedPre24) {
		isSupportedPre24 = supportedPre24;
	}

	public boolean isSupportedPre26() {
		return isSupportedPre26;
	}
	public void setSupportedPre26(boolean supportedPre26) {
		isSupportedPre26 = supportedPre26;
	}

	public boolean isSupportedPre28() {
		return isSupportedPre28;
	}
	public void setSupportedPre28(boolean supportedPre28) {
		isSupportedPre28 = supportedPre28;
	}

	public boolean isSupportedPre29() {
		return isSupportedPre29;
	}
	public void setSupportedPre29(boolean supportedPre29) {
		isSupportedPre29 = supportedPre29;
	}




	public static final String newString(int codePoint) {
		if (Character.charCount(codePoint) == 1) {
			return String.valueOf(codePoint);
		} else {
			return new String(Character.toChars(codePoint));
		}
	}
}
