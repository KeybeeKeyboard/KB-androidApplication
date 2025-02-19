package it.keybeeproject.keybee.model;

import java.util.ArrayList;

/**
 * Created by c161 on 20/09/16.
 */
public class EmojiPlace {

	/*public static final String A = "\uD83C\uDDE6";
	public static final String B = "\uD83C\uDDE7";
	public static final String C = "\uD83C\uDDE8";
	public static final String D = "\uD83C\uDDE9";
	public static final String E = "\uD83C\uDDEA";
	public static final String F = "\uD83C\uDDEB";
	public static final String G = "\uD83C\uDDEC";
	public static final String H = "\uD83C\uDDED";
	public static final String I = "\uD83C\uDDEE";
	public static final String J = "\uD83C\uDDEF";
	public static final String K = "\uD83C\uDDF0";
	public static final String L = "\uD83C\uDDEE";
	public static final String M = "\uD83C\uDDF2";
	public static final String N = "\uD83C\uDDF3";
	public static final String O = "\uD83C\uDDF4";
	public static final String P = "\uD83C\uDDF5";
	public static final String Q = "\uD83C\uDDF6";
	public static final String R = "\uD83C\uDDF7";
	public static final String S = "\uD83C\uDDF8";
	public static final String T = "\uD83C\uDDF9";
	public static final String U = "\uD83C\uDDFA";
	public static final String V = "\uD83C\uDDFB";
	public static final String W = "\uD83C\uDDFC";
	public static final String X = "\uD83C\uDDFD";
	public static final String Y = "\uD83C\uDDFE";
	public static final String Z = "\uD83C\uDDFF";

	public static final String[] FLAG_CHAR = {A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z};*/

	public static ArrayList<Emoji> getEmojies() {
		ArrayList<Emoji> emojies = new ArrayList<>();

		emojies.add(Emoji.fromString(("\ud83c\udf0d"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf0e"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf0f"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf10"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\uddfa\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\uddfe"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83e\udded"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83c\udfd4\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26f0\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf0b"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\uddfb"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfd5\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfd6\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfdc\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfdd\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfde\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfdf\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfdb\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfd7\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83e\uddf1"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83e\udea8"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83e\udeb5"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83d\uded6"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83c\udfd8\ufe0f"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfda\ufe0f"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfe0"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfe1"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfe2"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfe3"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfe4"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfe5"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfe6"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfe8"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfe9"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfea"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfeb"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfec"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfed"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfef"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udff0"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udc92"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\uddfc"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\uddfd"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26ea"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd4c"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\uded5"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83d\udd4d"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26e9\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd4b"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\u26f2"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26fa"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf01"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf03"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfd9\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf04"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf05"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf06"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf07"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf09"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u2668\ufe0f"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfa0"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfa1"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfa2"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udc88"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfaa"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude82"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude83"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude84"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude85"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude86"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude87"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude88"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude89"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude8a"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude9d"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude9e"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude8b"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude8c"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude8d"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude8e"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude90"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude91"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude92"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude93"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude94"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude95"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude96"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude97"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude98"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude99"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udefb"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83d\ude9a"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude9b"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude9c"),  false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfce\ufe0f"),  false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udfcd\ufe0f"),  false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udef5"), false,false,false,true,true,true));
		emojies.add(Emoji.fromString(("\ud83e\uddbd"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83e\uddbc"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83d\udefa"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83d\udeb2"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udef4"), false,false,false,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udef9"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83d\udefc"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83d\ude8f"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udee3\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udee4\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udee2\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26fd"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udea8"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udea5"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udea6"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\uded1"), false,false,false,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udea7"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u2693"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26f5"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udef6"), false,false,false,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udea4"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udef3\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26f4\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udee5\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udea2"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u2708\ufe0f"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udee9\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udeeb"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udeec"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83e\ude82"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\ud83d\udcba"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude81"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude9f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udea0"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udea1"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udef0\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\ude80"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udef8"), false,false,false,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udece\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83e\uddf3"), false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\u231b"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u23f3"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u231a"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u23f0"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u23f1\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\u23f2\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd70\ufe0f"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd5b"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd67"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd50"), true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd5c"), false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd51"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd5d"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd52"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd5e"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd53"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd5f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd54"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd60"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd55"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd61"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd56"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd62"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd57"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd63"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd58"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd64"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd59"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd65"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd5a"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd66"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf11"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf12"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf13"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf14"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf15"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf16"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf17"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf18"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf19"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf1a"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf1b"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf1c"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf21\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\u2600\ufe0f"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf1d"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf1e"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83e\ude90"),false,false,false,false,false,true));
		emojies.add(Emoji.fromString(("\u2b50"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf1f"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf20"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf0c"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u2601\ufe0f"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26c5"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26c8\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf24\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf25\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf26\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf27\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf28\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf29\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf2a\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf2b\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf2c\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf00"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf08"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf02"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u2602\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\u2614"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26f1\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26a1"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u2744\ufe0f"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u2603\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\u26c4"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\u2604\ufe0f"),false,false,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udd25"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83d\udca7"),true,true,true,true,true,true));
		emojies.add(Emoji.fromString(("\ud83c\udf0a"),true,true,true,true,true,true));


		/*emojies.add(Emoji.fromCodePoint(0x1f3e0,true));
		emojies.add(Emoji.fromCodePoint(0x1f3e1,true));
		emojies.add(Emoji.fromCodePoint(0x1f3eb,true));
		emojies.add(Emoji.fromCodePoint(0x1f3e2,true));
		emojies.add(Emoji.fromCodePoint(0x1f3e3,true));
		emojies.add(Emoji.fromCodePoint(0x1f3e5,true));
		emojies.add(Emoji.fromCodePoint(0x1f3e6, true));
		emojies.add(Emoji.fromCodePoint(0x1f3ea, true));
		emojies.add(Emoji.fromCodePoint(0x1f3e9, true));
		emojies.add(Emoji.fromCodePoint(0x1f3e8, true));
		emojies.add(Emoji.fromCodePoint(0x1f492, true));
		emojies.add(Emoji.fromChar((char) 0x26ea, true));
		emojies.add(Emoji.fromCodePoint(0x1f3ec, true));
		emojies.add(Emoji.fromCodePoint(0x1f3e4, false));
		emojies.add(Emoji.fromCodePoint(0x1f307, true));
		emojies.add(Emoji.fromCodePoint(0x1f306, true));
		emojies.add(Emoji.fromCodePoint(0x1f3ef, true));
		emojies.add(Emoji.fromCodePoint(0x1f3f0, true));
		emojies.add(Emoji.fromChar((char) 0x26fa, true));
		emojies.add(Emoji.fromCodePoint(0x1f3ed, true));
		emojies.add(Emoji.fromCodePoint(0x1f5fc, true));
		emojies.add(Emoji.fromCodePoint(0x1f5fe, true));
		emojies.add(Emoji.fromCodePoint(0x1f5fb, true));
		emojies.add(Emoji.fromCodePoint(0x1f304, true));
		emojies.add(Emoji.fromCodePoint(0x1f305, true));
		emojies.add(Emoji.fromCodePoint(0x1f303, true));
		emojies.add(Emoji.fromCodePoint(0x1f5fd, true));
		emojies.add(Emoji.fromCodePoint(0x1f309, true));
		emojies.add(Emoji.fromCodePoint(0x1f3a0, true));
		emojies.add(Emoji.fromCodePoint(0x1f3a1, true));
		emojies.add(Emoji.fromChar((char) 0x26f2, true));
		emojies.add(Emoji.fromCodePoint(0x1f3a2, true));
		emojies.add(Emoji.fromCodePoint(0x1f6a2, true));
		emojies.add(Emoji.fromChar((char) 0x26f5, true));
		emojies.add(Emoji.fromCodePoint(0x1f6a4, true));
		emojies.add(Emoji.fromCodePoint(0x1f6a3, false));
		emojies.add(Emoji.fromChar((char) 0x2693, true));
		emojies.add(Emoji.fromCodePoint(0x1f680, true));
		emojies.add(Emoji.fromChar((char) 0x2708, true));
		emojies.add(Emoji.fromCodePoint(0x1f4ba, true));
		emojies.add(Emoji.fromCodePoint(0x1f681, false));
		emojies.add(Emoji.fromCodePoint(0x1f682, false));
		emojies.add(Emoji.fromCodePoint(0x1f68a, false));
		emojies.add(Emoji.fromCodePoint(0x1f689, true));
		emojies.add(Emoji.fromCodePoint(0x1f69e, false));
		emojies.add(Emoji.fromCodePoint(0x1f686, false));
		emojies.add(Emoji.fromCodePoint(0x1f684, true));
		emojies.add(Emoji.fromCodePoint(0x1f685, true));
		emojies.add(Emoji.fromCodePoint(0x1f688, false));
		emojies.add(Emoji.fromCodePoint(0x1f687, true));
		emojies.add(Emoji.fromCodePoint(0x1f69d, false));
		emojies.add(Emoji.fromCodePoint(0x1f68b, false));
		emojies.add(Emoji.fromCodePoint(0x1f683, true));
		emojies.add(Emoji.fromCodePoint(0x1f68e, false));
		emojies.add(Emoji.fromCodePoint(0x1f68c, true));
		emojies.add(Emoji.fromCodePoint(0x1f68d, false));
		emojies.add(Emoji.fromCodePoint(0x1f699, true));
		emojies.add(Emoji.fromCodePoint(0x1f698, false));
		emojies.add(Emoji.fromCodePoint(0x1f697, true));
		emojies.add(Emoji.fromCodePoint(0x1f695, true));
		emojies.add(Emoji.fromCodePoint(0x1f696, false));
		emojies.add(Emoji.fromCodePoint(0x1f69b, false));
		emojies.add(Emoji.fromCodePoint(0x1f69a, true));
		emojies.add(Emoji.fromCodePoint(0x1f6a8, true));
		emojies.add(Emoji.fromCodePoint(0x1f693, true));
		emojies.add(Emoji.fromCodePoint(0x1f694, false));
		emojies.add(Emoji.fromCodePoint(0x1f692, true));
		emojies.add(Emoji.fromCodePoint(0x1f691, true));
		emojies.add(Emoji.fromCodePoint(0x1f690, false));
		emojies.add(Emoji.fromCodePoint(0x1f6b2, true));
		emojies.add(Emoji.fromCodePoint(0x1f6a1, false));
		emojies.add(Emoji.fromCodePoint(0x1f69f, false));
		emojies.add(Emoji.fromCodePoint(0x1f6a0, false));
		emojies.add(Emoji.fromCodePoint(0x1f69c, false));
		emojies.add(Emoji.fromCodePoint(0x1f488, true));
		emojies.add(Emoji.fromCodePoint(0x1f68f, true));
		emojies.add(Emoji.fromCodePoint(0x1f3ab, true));
		emojies.add(Emoji.fromCodePoint(0x1f6a6, false));
		emojies.add(Emoji.fromCodePoint(0x1f6a5, true));
		emojies.add(Emoji.fromChar((char) 0x26a0, true));
		emojies.add(Emoji.fromCodePoint(0x1f6a7, true));
		emojies.add(Emoji.fromCodePoint(0x1f530, true));
		emojies.add(Emoji.fromChar((char) 0x26fd, true));
		emojies.add(Emoji.fromCodePoint(0x1f3ee, true));
		emojies.add(Emoji.fromCodePoint(0x1f3b0, true));
		emojies.add(Emoji.fromChar((char) 0x2668, true));
		emojies.add(Emoji.fromCodePoint(0x1f5ff, true));
		emojies.add(Emoji.fromCodePoint(0x1f3aa, true));
		emojies.add(Emoji.fromCodePoint(0x1f3ad, true));
		emojies.add(Emoji.fromCodePoint(0x1f4cd, true));
	*/
		/*emojies.add(Emoji.fromCodePoint(0x1f6a9, true));
		emojies.add(Emoji.fromString(C + N, false, false));
		emojies.add(Emoji.fromString(D + E, false, false));
		emojies.add(Emoji.fromString(E + S, false, false));
		emojies.add(Emoji.fromString(F + R, false, false));
		emojies.add(Emoji.fromString(G + B, false, false));
		emojies.add(Emoji.fromString(I + T, false, false));
		emojies.add(Emoji.fromString(J + P, false, false));
		emojies.add(Emoji.fromString(K + R, false, false));
		emojies.add(Emoji.fromString(R + U, false, false));
		emojies.add(Emoji.fromString(U + S, false, false));
		emojies.add(Emoji.fromString(A + D, false, false));
		emojies.add(Emoji.fromString(A + E, false, false));
		emojies.add(Emoji.fromString(A + F, false, false));
		emojies.add(Emoji.fromString(A + G, false, false));
		emojies.add(Emoji.fromString(A + I, false, false));
		emojies.add(Emoji.fromString(A + L, false, false));
		emojies.add(Emoji.fromString(A + M, false, false));
		emojies.add(Emoji.fromString(A + O, false, false));
		emojies.add(Emoji.fromString(A + R, false, false));
		emojies.add(Emoji.fromString(A + S, false, false));
		emojies.add(Emoji.fromString(A + T, false, false));
		emojies.add(Emoji.fromString(A + U, false, false));
		emojies.add(Emoji.fromString(A + W, false, false));
		emojies.add(Emoji.fromString(A + X, false, false));
		emojies.add(Emoji.fromString(A + Z, false, false));
		emojies.add(Emoji.fromString(B + A, false, false));
		emojies.add(Emoji.fromString(B + B, false, false));
		emojies.add(Emoji.fromString(B + D, false, false));
		emojies.add(Emoji.fromString(B + E, false, false));
		emojies.add(Emoji.fromString(B + F, false, false));
		emojies.add(Emoji.fromString(B + G, false, false));
		emojies.add(Emoji.fromString(B + H, false, false));
		emojies.add(Emoji.fromString(B + I, false, false));
		emojies.add(Emoji.fromString(B + J, false, false));
		emojies.add(Emoji.fromString(B + L, false, false));
		emojies.add(Emoji.fromString(B + M, false, false));
		emojies.add(Emoji.fromString(B + N, false, false));
		emojies.add(Emoji.fromString(B + O, false, false));
		emojies.add(Emoji.fromString(B + R, false, false));
		emojies.add(Emoji.fromString(B + S, false, false));
		emojies.add(Emoji.fromString(B + T, false, false));
		emojies.add(Emoji.fromString(B + W, false, false));
		emojies.add(Emoji.fromString(B + Y, false, false));
		emojies.add(Emoji.fromString(B + Z, false, false));
		emojies.add(Emoji.fromString(C + A, false, false));
		emojies.add(Emoji.fromString(C + C, false, false));
		emojies.add(Emoji.fromString(C + D, false, false));
		emojies.add(Emoji.fromString(C + F, false, false));
		emojies.add(Emoji.fromString(C + G, false, false));
		emojies.add(Emoji.fromString(C + H, false, false));
		emojies.add(Emoji.fromString(C + I, false, false));
		emojies.add(Emoji.fromString(C + K, false, false));
		emojies.add(Emoji.fromString(C + L, false, false));
		emojies.add(Emoji.fromString(C + M, false, false));
		emojies.add(Emoji.fromString(C + N, false, false));
		emojies.add(Emoji.fromString(C + O, false, false));
		emojies.add(Emoji.fromString(C + R, false, false));
		emojies.add(Emoji.fromString(C + U, false, false));
		emojies.add(Emoji.fromString(C + V, false, false));
		emojies.add(Emoji.fromString(C + W, false, false));
		emojies.add(Emoji.fromString(C + X, false, false));
		emojies.add(Emoji.fromString(C + Y, false, false));
		emojies.add(Emoji.fromString(C + Z, false, false));
		emojies.add(Emoji.fromString(D + E, false, false));
		emojies.add(Emoji.fromString(D + J, false, false));
		emojies.add(Emoji.fromString(D + K, false, false));
		emojies.add(Emoji.fromString(D + M, false, false));
		emojies.add(Emoji.fromString(D + O, false, false));
		emojies.add(Emoji.fromString(D + Z, false, false));
		emojies.add(Emoji.fromString(E + C, false, false));
		emojies.add(Emoji.fromString(E + E, false, false));
		emojies.add(Emoji.fromString(E + G, false, false));
		emojies.add(Emoji.fromString(E + R, false, false));
		emojies.add(Emoji.fromString(E + S, false, false));
		emojies.add(Emoji.fromString(E + T, false, false));
		emojies.add(Emoji.fromString(F + I, false, false));
		emojies.add(Emoji.fromString(F + J, false, false));
		emojies.add(Emoji.fromString(F + M, false, false));
		emojies.add(Emoji.fromString(F + O, false, false));
		emojies.add(Emoji.fromString(F + R, false, false));
		emojies.add(Emoji.fromString(G + A, false, false));
		emojies.add(Emoji.fromString(G + B, false, false));
		emojies.add(Emoji.fromString(G + D, false, false));
		emojies.add(Emoji.fromString(G + E, false, false));
		emojies.add(Emoji.fromString(G + G, false, false));
		emojies.add(Emoji.fromString(G + H, false, false));
		emojies.add(Emoji.fromString(G + I, false, false));
		emojies.add(Emoji.fromString(G + L, false, false));
		emojies.add(Emoji.fromString(G + M, false, false));
		emojies.add(Emoji.fromString(G + N, false, false));
		emojies.add(Emoji.fromString(G + Q, false, false));
		emojies.add(Emoji.fromString(G + R, false, false));
		emojies.add(Emoji.fromString(G + T, false, false));
		emojies.add(Emoji.fromString(G + U, false, false));
		emojies.add(Emoji.fromString(G + W, false, false));
		emojies.add(Emoji.fromString(G + Y, false, false));
		emojies.add(Emoji.fromString(H + K, false, false));
		emojies.add(Emoji.fromString(H + N, false, false));
		emojies.add(Emoji.fromString(H + R, false, false));
		emojies.add(Emoji.fromString(H + T, false, false));
		emojies.add(Emoji.fromString(H + U, false, false));
		emojies.add(Emoji.fromString(I + D, false, false));
		emojies.add(Emoji.fromString(I + E, false, false));
		emojies.add(Emoji.fromString(I + M, false, false));
		emojies.add(Emoji.fromString(I + N, false, false));
		emojies.add(Emoji.fromString(I + O, false, false));
		emojies.add(Emoji.fromString(I + Q, false, false));
		emojies.add(Emoji.fromString(I + R, false, false));
		emojies.add(Emoji.fromString(I + S, false, false));
		emojies.add(Emoji.fromString(I + T, false, false));
		emojies.add(Emoji.fromString(J + E, false, false));
		emojies.add(Emoji.fromString(J + M, false, false));
		emojies.add(Emoji.fromString(J + O, false, false));
		emojies.add(Emoji.fromString(J + P, false, false));
		emojies.add(Emoji.fromString(K + E, false, false));
		emojies.add(Emoji.fromString(K + G, false, false));
		emojies.add(Emoji.fromString(K + H, false, false));
		emojies.add(Emoji.fromString(K + I, false, false));
		emojies.add(Emoji.fromString(K + M, false, false));
		emojies.add(Emoji.fromString(K + N, false, false));
		emojies.add(Emoji.fromString(K + P, false, false));
		emojies.add(Emoji.fromString(K + R, false, false));
		emojies.add(Emoji.fromString(K + W, false, false));
		emojies.add(Emoji.fromString(K + Y, false, false));
		emojies.add(Emoji.fromString(K + Z, false, false));
		emojies.add(Emoji.fromString(L + R, false, false));
		emojies.add(Emoji.fromString(L + S, false, false));
		emojies.add(Emoji.fromString(L + T, false, false));
		emojies.add(Emoji.fromString(M + A, false, false));
		emojies.add(Emoji.fromString(M + C, false, false));
		emojies.add(Emoji.fromString(M + D, false, false));
		emojies.add(Emoji.fromString(M + E, false, false));
		emojies.add(Emoji.fromString(M + G, false, false));
		emojies.add(Emoji.fromString(M + H, false, false));
		emojies.add(Emoji.fromString(M + K, false, false));
		emojies.add(Emoji.fromString(M + M, false, false));
		emojies.add(Emoji.fromString(M + N, false, false));
		emojies.add(Emoji.fromString(M + O, false, false));
		emojies.add(Emoji.fromString(M + P, false, false));
		emojies.add(Emoji.fromString(M + R, false, false));
		emojies.add(Emoji.fromString(M + S, false, false));
		emojies.add(Emoji.fromString(M + T, false, false));
		emojies.add(Emoji.fromString(M + U, false, false));
		emojies.add(Emoji.fromString(M + V, false, false));
		emojies.add(Emoji.fromString(M + W, false, false));
		emojies.add(Emoji.fromString(M + X, false, false));
		emojies.add(Emoji.fromString(M + Y, false, false));
		emojies.add(Emoji.fromString(M + Z, false, false));
		emojies.add(Emoji.fromString(N + A, false, false));
		emojies.add(Emoji.fromString(N + E, false, false));
		emojies.add(Emoji.fromString(N + F, false, false));
		emojies.add(Emoji.fromString(N + G, false, false));
		emojies.add(Emoji.fromString(N + I, false, false));
		emojies.add(Emoji.fromString(N + L, false, false));
		emojies.add(Emoji.fromString(N + O, false, false));
		emojies.add(Emoji.fromString(N + P, false, false));
		emojies.add(Emoji.fromString(N + R, false, false));
		emojies.add(Emoji.fromString(N + U, false, false));
		emojies.add(Emoji.fromString(N + Z, false, false));
		emojies.add(Emoji.fromString(O + M, false, false));
		emojies.add(Emoji.fromString(P + A, false, false));
		emojies.add(Emoji.fromString(P + E, false, false));
		emojies.add(Emoji.fromString(P + F, false, false));
		emojies.add(Emoji.fromString(P + G, false, false));
		emojies.add(Emoji.fromString(P + H, false, false));
		emojies.add(Emoji.fromString(P + K, false, false));
		emojies.add(Emoji.fromString(P + N, false, false));
		emojies.add(Emoji.fromString(P + R, false, false));
		emojies.add(Emoji.fromString(P + S, false, false));
		emojies.add(Emoji.fromString(P + T, false, false));
		emojies.add(Emoji.fromString(P + W, false, false));
		emojies.add(Emoji.fromString(P + Y, false, false));
		emojies.add(Emoji.fromString(Q + A, false, false));
		emojies.add(Emoji.fromString(R + O, false, false));
		emojies.add(Emoji.fromString(R + S, false, false));
		emojies.add(Emoji.fromString(R + U, false, false));
		emojies.add(Emoji.fromString(R + W, false, false));
		emojies.add(Emoji.fromString(S + A, false, false));
		emojies.add(Emoji.fromString(S + B, false, false));
		emojies.add(Emoji.fromString(S + C, false, false));
		emojies.add(Emoji.fromString(S + D, false, false));
		emojies.add(Emoji.fromString(S + E, false, false));
		emojies.add(Emoji.fromString(S + G, false, false));
		emojies.add(Emoji.fromString(S + I, false, false));
		emojies.add(Emoji.fromString(S + K, false, false));
		emojies.add(Emoji.fromString(S + L, false, false));
		emojies.add(Emoji.fromString(S + M, false, false));
		emojies.add(Emoji.fromString(S + N, false, false));
		emojies.add(Emoji.fromString(S + O, false, false));
		emojies.add(Emoji.fromString(S + R, false, false));
		emojies.add(Emoji.fromString(S + S, false, false));
		emojies.add(Emoji.fromString(S + T, false, false));
		emojies.add(Emoji.fromString(S + V, false, false));
		emojies.add(Emoji.fromString(S + X, false, false));
		emojies.add(Emoji.fromString(S + Y, false, false));
		emojies.add(Emoji.fromString(S + Z, false, false));
		emojies.add(Emoji.fromString(T + C, false, false));
		emojies.add(Emoji.fromString(T + D, false, false));
		emojies.add(Emoji.fromString(T + G, false, false));
		emojies.add(Emoji.fromString(T + H, false, false));
		emojies.add(Emoji.fromString(T + J, false, false));
		emojies.add(Emoji.fromString(T + K, false, false));
		emojies.add(Emoji.fromString(T + M, false, false));
		emojies.add(Emoji.fromString(T + N, false, false));
		emojies.add(Emoji.fromString(T + O, false, false));
		emojies.add(Emoji.fromString(T + R, false, false));
		emojies.add(Emoji.fromString(T + T, false, false));
		emojies.add(Emoji.fromString(T + V, false, false));
		emojies.add(Emoji.fromString(T + W, false, false));
		emojies.add(Emoji.fromString(T + Z, false, false));
		emojies.add(Emoji.fromString(U + A, false, false));
		emojies.add(Emoji.fromString(U + G, false, false));
		emojies.add(Emoji.fromString(U + S, false, false));
		emojies.add(Emoji.fromString(U + Y, false, false));
		emojies.add(Emoji.fromString(U + Z, false, false));
		emojies.add(Emoji.fromString(V + A, false, false));
		emojies.add(Emoji.fromString(V + C, false, false));
		emojies.add(Emoji.fromString(V + E, false, false));
		emojies.add(Emoji.fromString(V + G, false, false));
		emojies.add(Emoji.fromString(V + I, false, false));
		emojies.add(Emoji.fromString(V + N, false, false));
		emojies.add(Emoji.fromString(V + U, false, false));
		emojies.add(Emoji.fromString(W + S, false, false));
		emojies.add(Emoji.fromString(Y + E, false, false));
		emojies.add(Emoji.fromString(Z + A, false, false));
		emojies.add(Emoji.fromString(Z + M, false, false));
		emojies.add(Emoji.fromString(Z + W, false, false));*/

		return emojies;
	}
}
