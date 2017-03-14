package retroscope.rql;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/2/17 5:02 PM from the specification file
 * <tt>D:/Dropbox/ubuntu_vms_share/retroscope-lib/rql-server/src/main/java/retroscope/rql/rql.flex</tt>
 */
public class Scanner implements mTokens {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;
  private static final String ZZ_NL = System.getProperty("line.separator");

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\10\1\3\1\2\1\0\1\3\1\1\16\10\4\0\1\3\1\55"+
    "\1\43\1\6\1\7\1\45\1\56\1\0\1\47\1\50\1\5\1\44"+
    "\1\65\1\42\1\40\1\4\1\11\11\12\1\63\1\64\1\61\1\60"+
    "\1\62\2\0\1\17\1\35\1\23\1\36\1\13\1\25\1\7\1\32"+
    "\1\20\1\7\1\33\1\16\1\30\1\21\1\27\1\15\1\7\1\26"+
    "\1\22\1\24\1\37\1\7\1\31\1\14\2\7\1\53\1\0\1\54"+
    "\1\46\1\34\1\0\4\7\1\41\25\7\1\51\1\57\1\52\1\0"+
    "\41\10\2\0\4\7\4\0\1\7\2\0\1\10\7\0\1\7\4\0"+
    "\1\7\5\0\27\7\1\0\37\7\1\0\u01ca\7\4\0\14\7\16\0"+
    "\5\7\7\0\1\7\1\0\1\7\21\0\160\10\5\7\1\0\2\7"+
    "\2\0\4\7\10\0\1\7\1\0\3\7\1\0\1\7\1\0\24\7"+
    "\1\0\123\7\1\0\213\7\1\0\5\10\2\0\236\7\11\0\46\7"+
    "\2\0\1\7\7\0\47\7\7\0\1\7\1\0\55\10\1\0\1\10"+
    "\1\0\2\10\1\0\2\10\1\0\1\10\10\0\33\7\5\0\3\7"+
    "\15\0\5\10\6\0\1\7\4\0\13\10\5\0\53\7\37\10\4\0"+
    "\2\7\1\10\143\7\1\0\1\7\10\10\1\0\6\10\2\7\2\10"+
    "\1\0\4\10\2\7\12\10\3\7\2\0\1\7\17\0\1\10\1\7"+
    "\1\10\36\7\33\10\2\0\131\7\13\10\1\7\16\0\12\10\41\7"+
    "\11\10\2\7\4\0\1\7\5\0\26\7\4\10\1\7\11\10\1\7"+
    "\3\10\1\7\5\10\22\0\31\7\3\10\104\0\1\7\1\0\13\7"+
    "\67\0\33\10\1\0\4\10\66\7\3\10\1\7\22\10\1\7\7\10"+
    "\12\7\2\10\2\0\12\10\1\0\7\7\1\0\7\7\1\0\3\10"+
    "\1\0\10\7\2\0\2\7\2\0\26\7\1\0\7\7\1\0\1\7"+
    "\3\0\4\7\2\0\1\10\1\7\7\10\2\0\2\10\2\0\3\10"+
    "\1\7\10\0\1\10\4\0\2\7\1\0\3\7\2\10\2\0\12\10"+
    "\4\7\7\0\1\7\5\0\3\10\1\0\6\7\4\0\2\7\2\0"+
    "\26\7\1\0\7\7\1\0\2\7\1\0\2\7\1\0\2\7\2\0"+
    "\1\10\1\0\5\10\4\0\2\10\2\0\3\10\3\0\1\10\7\0"+
    "\4\7\1\0\1\7\7\0\14\10\3\7\1\10\13\0\3\10\1\0"+
    "\11\7\1\0\3\7\1\0\26\7\1\0\7\7\1\0\2\7\1\0"+
    "\5\7\2\0\1\10\1\7\10\10\1\0\3\10\1\0\3\10\2\0"+
    "\1\7\17\0\2\7\2\10\2\0\12\10\1\0\1\7\17\0\3\10"+
    "\1\0\10\7\2\0\2\7\2\0\26\7\1\0\7\7\1\0\2\7"+
    "\1\0\5\7\2\0\1\10\1\7\7\10\2\0\2\10\2\0\3\10"+
    "\10\0\2\10\4\0\2\7\1\0\3\7\2\10\2\0\12\10\1\0"+
    "\1\7\20\0\1\10\1\7\1\0\6\7\3\0\3\7\1\0\4\7"+
    "\3\0\2\7\1\0\1\7\1\0\2\7\3\0\2\7\3\0\3\7"+
    "\3\0\14\7\4\0\5\10\3\0\3\10\1\0\4\10\2\0\1\7"+
    "\6\0\1\10\16\0\12\10\11\0\1\7\7\0\3\10\1\0\10\7"+
    "\1\0\3\7\1\0\27\7\1\0\12\7\1\0\5\7\3\0\1\7"+
    "\7\10\1\0\3\10\1\0\4\10\7\0\2\10\1\0\2\7\6\0"+
    "\2\7\2\10\2\0\12\10\22\0\2\10\1\0\10\7\1\0\3\7"+
    "\1\0\27\7\1\0\12\7\1\0\5\7\2\0\1\10\1\7\7\10"+
    "\1\0\3\10\1\0\4\10\7\0\2\10\7\0\1\7\1\0\2\7"+
    "\2\10\2\0\12\10\1\0\2\7\17\0\2\10\1\0\10\7\1\0"+
    "\3\7\1\0\51\7\2\0\1\7\7\10\1\0\3\10\1\0\4\10"+
    "\1\7\10\0\1\10\10\0\2\7\2\10\2\0\12\10\12\0\6\7"+
    "\2\0\2\10\1\0\22\7\3\0\30\7\1\0\11\7\1\0\1\7"+
    "\2\0\7\7\3\0\1\10\4\0\6\10\1\0\1\10\1\0\10\10"+
    "\22\0\2\10\15\0\60\7\1\10\2\7\7\10\4\0\10\7\10\10"+
    "\1\0\12\10\47\0\2\7\1\0\1\7\2\0\2\7\1\0\1\7"+
    "\2\0\1\7\6\0\4\7\1\0\7\7\1\0\3\7\1\0\1\7"+
    "\1\0\1\7\2\0\2\7\1\0\4\7\1\10\2\7\6\10\1\0"+
    "\2\10\1\7\2\0\5\7\1\0\1\7\1\0\6\10\2\0\12\10"+
    "\2\0\4\7\40\0\1\7\27\0\2\10\6\0\12\10\13\0\1\10"+
    "\1\0\1\10\1\0\1\10\4\0\2\10\10\7\1\0\44\7\4\0"+
    "\24\10\1\0\2\10\5\7\13\10\1\0\44\10\11\0\1\10\71\0"+
    "\53\7\24\10\1\7\12\10\6\0\6\7\4\10\4\7\3\10\1\7"+
    "\3\10\2\7\7\10\3\7\4\10\15\7\14\10\1\7\17\10\2\0"+
    "\46\7\1\0\1\7\5\0\1\7\2\0\53\7\1\0\u014d\7\1\0"+
    "\4\7\2\0\7\7\1\0\1\7\1\0\4\7\2\0\51\7\1\0"+
    "\4\7\2\0\41\7\1\0\4\7\2\0\7\7\1\0\1\7\1\0"+
    "\4\7\2\0\17\7\1\0\71\7\1\0\4\7\2\0\103\7\2\0"+
    "\3\10\40\0\20\7\20\0\125\7\14\0\u026c\7\2\0\21\7\1\0"+
    "\32\7\5\0\113\7\3\0\3\7\17\0\15\7\1\0\4\7\3\10"+
    "\13\0\22\7\3\10\13\0\22\7\2\10\14\0\15\7\1\0\3\7"+
    "\1\0\2\10\14\0\64\7\40\10\3\0\1\7\3\0\2\7\1\10"+
    "\2\0\12\10\41\0\3\10\2\0\12\10\6\0\130\7\10\0\51\7"+
    "\1\10\1\7\5\0\106\7\12\0\35\7\3\0\14\10\4\0\14\10"+
    "\12\0\12\10\36\7\2\0\5\7\13\0\54\7\4\0\21\10\7\7"+
    "\2\10\6\0\12\10\46\0\27\7\5\10\4\0\65\7\12\10\1\0"+
    "\35\10\2\0\13\10\6\0\12\10\15\0\1\7\130\0\5\10\57\7"+
    "\21\10\7\7\4\0\12\10\21\0\11\10\14\0\3\10\36\7\15\10"+
    "\2\7\12\10\54\7\16\10\14\0\44\7\24\10\10\0\12\10\3\0"+
    "\3\7\12\10\44\7\122\0\3\10\1\0\25\10\4\7\1\10\4\7"+
    "\3\10\2\7\11\0\300\7\47\10\25\0\4\10\u0116\7\2\0\6\7"+
    "\2\0\46\7\2\0\6\7\2\0\10\7\1\0\1\7\1\0\1\7"+
    "\1\0\1\7\1\0\37\7\2\0\65\7\1\0\7\7\1\0\1\7"+
    "\3\0\3\7\1\0\7\7\3\0\4\7\2\0\6\7\4\0\15\7"+
    "\5\0\3\7\1\0\7\7\16\0\5\10\32\0\5\10\20\0\2\7"+
    "\23\0\1\7\13\0\5\10\5\0\6\10\1\0\1\7\15\0\1\7"+
    "\20\0\15\7\3\0\33\7\25\0\15\10\4\0\1\10\3\0\14\10"+
    "\21\0\1\7\4\0\1\7\2\0\12\7\1\0\1\7\3\0\5\7"+
    "\6\0\1\7\1\0\1\7\1\0\1\7\1\0\4\7\1\0\13\7"+
    "\2\0\4\7\5\0\5\7\4\0\1\7\21\0\51\7\u0a77\0\57\7"+
    "\1\0\57\7\1\0\205\7\6\0\4\7\3\10\2\7\14\0\46\7"+
    "\1\0\1\7\5\0\1\7\2\0\70\7\7\0\1\7\17\0\1\10"+
    "\27\7\11\0\7\7\1\0\7\7\1\0\7\7\1\0\7\7\1\0"+
    "\7\7\1\0\7\7\1\0\7\7\1\0\7\7\1\0\40\10\57\0"+
    "\1\7\u01d5\0\3\7\31\0\11\7\6\10\1\0\5\7\2\0\5\7"+
    "\4\0\126\7\2\0\2\10\2\0\3\7\1\0\132\7\1\0\4\7"+
    "\5\0\51\7\3\0\136\7\21\0\33\7\65\0\20\7\u0200\0\u19b6\7"+
    "\112\0\u51cd\7\63\0\u048d\7\103\0\56\7\2\0\u010d\7\3\0\20\7"+
    "\12\10\2\7\24\0\57\7\1\10\4\0\12\10\1\0\31\7\7\0"+
    "\1\10\120\7\2\10\45\0\11\7\2\0\147\7\2\0\4\7\1\0"+
    "\4\7\14\0\13\7\115\0\12\7\1\10\3\7\1\10\4\7\1\10"+
    "\27\7\5\10\20\0\1\7\7\0\64\7\14\0\2\10\62\7\21\10"+
    "\13\0\12\10\6\0\22\10\6\7\3\0\1\7\4\0\12\10\34\7"+
    "\10\10\2\0\27\7\15\10\14\0\35\7\3\0\4\10\57\7\16\10"+
    "\16\0\1\7\12\10\46\0\51\7\16\10\11\0\3\7\1\10\10\7"+
    "\2\10\2\0\12\10\6\0\27\7\3\0\1\7\1\10\4\0\60\7"+
    "\1\10\1\7\3\10\2\7\2\10\5\7\2\10\1\7\1\10\1\7"+
    "\30\0\3\7\2\0\13\7\5\10\2\0\3\7\2\10\12\0\6\7"+
    "\2\0\6\7\2\0\6\7\11\0\7\7\1\0\7\7\221\0\43\7"+
    "\10\10\1\0\2\10\2\0\12\10\6\0\u2ba4\7\14\0\27\7\4\0"+
    "\61\7\u2104\0\u016e\7\2\0\152\7\46\0\7\7\14\0\5\7\5\0"+
    "\1\7\1\10\12\7\1\0\15\7\1\0\5\7\1\0\1\7\1\0"+
    "\2\7\1\0\2\7\1\0\154\7\41\0\u016b\7\22\0\100\7\2\0"+
    "\66\7\50\0\15\7\3\0\20\10\20\0\7\10\14\0\2\7\30\0"+
    "\3\7\31\0\1\7\6\0\5\7\1\0\207\7\2\0\1\10\4\0"+
    "\1\7\13\0\12\10\7\0\32\7\4\0\1\7\1\0\32\7\13\0"+
    "\131\7\3\0\6\7\2\0\6\7\2\0\6\7\2\0\3\7\3\0"+
    "\2\7\3\0\2\7\22\0\3\10\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\1\1\1\5\2\6"+
    "\13\5\1\7\1\10\1\1\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\1\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\2\0\1\32"+
    "\1\0\2\5\1\0\2\5\1\33\10\5\1\34\2\5"+
    "\1\35\1\36\2\5\1\32\1\37\1\40\1\41\1\36"+
    "\1\42\1\43\1\44\1\0\3\5\1\41\4\5\1\45"+
    "\11\5\1\0\1\5\1\46\6\5\1\47\1\50\2\5"+
    "\1\51\1\52\2\5\1\32\1\0\2\5\1\53\1\54"+
    "\2\5\1\55\1\56\5\5\1\57\3\5\1\60\1\61"+
    "\2\5\1\62\1\63\2\5\1\64\1\65";

  private static int [] zzUnpackAction() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\66\0\154\0\66\0\242\0\66\0\330\0\u010e"+
    "\0\u0144\0\u017a\0\u01b0\0\u01e6\0\u021c\0\u0252\0\u0288\0\u02be"+
    "\0\u02f4\0\u032a\0\u0360\0\u0396\0\u03cc\0\u0402\0\66\0\u0438"+
    "\0\66\0\66\0\66\0\66\0\66\0\66\0\66\0\66"+
    "\0\66\0\u046e\0\u04a4\0\u04da\0\u0510\0\u0546\0\u057c\0\66"+
    "\0\66\0\66\0\u05b2\0\330\0\u0144\0\u0402\0\u05e8\0\u061e"+
    "\0\u0438\0\u0654\0\u068a\0\u010e\0\u06c0\0\u06f6\0\u072c\0\u0762"+
    "\0\u0798\0\u07ce\0\u0804\0\u083a\0\u010e\0\u0870\0\u08a6\0\u010e"+
    "\0\u010e\0\u08dc\0\u0912\0\u0948\0\66\0\66\0\66\0\66"+
    "\0\66\0\66\0\66\0\u097e\0\u09b4\0\u09ea\0\u0a20\0\u010e"+
    "\0\u0a56\0\u0a8c\0\u0ac2\0\u0af8\0\u010e\0\u0b2e\0\u0b64\0\u0b9a"+
    "\0\u0bd0\0\u0c06\0\u0c3c\0\u0c72\0\u0ca8\0\u0cde\0\u0d14\0\u0d4a"+
    "\0\u010e\0\u0d80\0\u0db6\0\u0dec\0\u0e22\0\u0e58\0\u0e8e\0\u010e"+
    "\0\u010e\0\u0ec4\0\u0efa\0\u010e\0\u010e\0\u0f30\0\u0f66\0\u0f9c"+
    "\0\u0f9c\0\u0fd2\0\u1008\0\u010e\0\u010e\0\u103e\0\u1074\0\u010e"+
    "\0\u010e\0\u10aa\0\u10e0\0\u1116\0\u114c\0\u1182\0\u010e\0\u11b8"+
    "\0\u11ee\0\u1224\0\u010e\0\u010e\0\u125a\0\u1290\0\u010e\0\u010e"+
    "\0\u12c6\0\u12fc\0\u010e\0\u010e";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\4\1\5\1\6\1\7\1\10\1\2"+
    "\1\11\1\12\1\13\2\10\1\14\1\15\1\10\1\16"+
    "\1\17\1\20\1\21\1\22\1\10\1\23\1\10\1\24"+
    "\3\10\1\25\2\10\1\26\1\10\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51"+
    "\1\52\70\0\1\4\70\0\1\53\60\0\1\54\1\3"+
    "\1\4\63\54\7\0\31\10\1\0\1\10\35\0\2\55"+
    "\25\0\1\56\36\0\2\12\25\0\1\56\34\0\5\10"+
    "\1\57\23\10\1\0\1\10\33\0\11\10\1\60\17\10"+
    "\1\0\1\10\1\0\1\61\31\0\7\10\1\62\2\10"+
    "\1\63\2\10\1\64\1\65\12\10\1\0\1\10\33\0"+
    "\20\10\1\66\10\10\1\0\1\10\33\0\4\10\1\67"+
    "\3\10\1\70\17\10\1\71\1\0\1\10\33\0\20\10"+
    "\1\72\10\10\1\0\1\10\33\0\11\10\1\73\5\10"+
    "\1\74\1\75\10\10\1\0\1\10\33\0\10\10\1\76"+
    "\6\10\1\77\11\10\1\0\1\10\33\0\12\10\1\100"+
    "\4\10\1\101\11\10\1\0\1\10\33\0\23\10\1\102"+
    "\5\10\1\0\1\10\33\0\4\10\1\103\24\10\1\0"+
    "\1\10\35\0\2\104\53\0\43\61\1\105\22\61\60\0"+
    "\1\106\63\0\1\107\66\0\1\110\66\0\1\111\65\0"+
    "\1\112\65\0\1\113\5\0\5\53\1\114\60\53\7\0"+
    "\6\10\1\115\22\10\1\0\1\10\33\0\12\10\1\116"+
    "\16\10\1\0\1\10\33\0\7\10\1\117\21\10\1\0"+
    "\1\10\33\0\27\10\1\120\1\10\1\0\1\10\33\0"+
    "\15\10\1\121\13\10\1\0\1\10\33\0\27\10\1\122"+
    "\1\10\1\0\1\10\33\0\7\10\1\123\21\10\1\0"+
    "\1\10\33\0\21\10\1\124\7\10\1\0\1\10\33\0"+
    "\21\10\1\125\7\10\1\0\1\10\33\0\30\10\1\126"+
    "\1\0\1\10\33\0\21\10\1\127\7\10\1\0\1\10"+
    "\33\0\30\10\1\130\1\0\1\10\33\0\7\10\1\131"+
    "\15\10\1\132\3\10\1\0\1\10\33\0\20\10\1\133"+
    "\10\10\1\0\1\10\33\0\4\10\1\134\24\10\1\0"+
    "\1\10\33\0\15\10\1\135\1\136\12\10\1\0\1\10"+
    "\35\0\2\104\1\137\25\0\1\137\24\0\4\53\1\4"+
    "\1\114\60\53\7\0\7\10\1\140\21\10\1\0\1\10"+
    "\33\0\24\10\1\141\4\10\1\0\1\10\33\0\25\10"+
    "\1\142\3\10\1\0\1\10\33\0\4\10\1\143\24\10"+
    "\1\0\1\10\33\0\4\10\1\144\24\10\1\0\1\10"+
    "\33\0\4\10\1\145\24\10\1\0\1\10\33\0\4\10"+
    "\1\146\24\10\1\0\1\10\33\0\12\10\1\147\16\10"+
    "\1\0\1\10\33\0\4\10\1\150\24\10\1\0\1\10"+
    "\33\0\4\10\1\151\24\10\1\0\1\10\33\0\13\10"+
    "\1\152\15\10\1\0\1\10\33\0\7\10\1\153\21\10"+
    "\1\0\1\10\33\0\21\10\1\154\7\10\1\0\1\10"+
    "\33\0\12\10\1\155\16\10\1\0\1\10\33\0\22\10"+
    "\1\156\6\10\1\0\1\10\33\0\20\10\1\157\10\10"+
    "\1\0\1\10\35\0\2\160\27\0\1\161\1\0\1\161"+
    "\30\0\10\10\1\162\20\10\1\0\1\10\33\0\12\10"+
    "\1\163\16\10\1\0\1\10\33\0\17\10\1\164\11\10"+
    "\1\0\1\10\33\0\13\10\1\165\15\10\1\0\1\10"+
    "\33\0\14\10\1\166\14\10\1\0\1\10\33\0\25\10"+
    "\1\167\3\10\1\0\1\10\33\0\15\10\1\170\13\10"+
    "\1\0\1\10\33\0\4\10\1\171\24\10\1\0\1\10"+
    "\33\0\11\10\1\172\17\10\1\0\1\10\33\0\4\10"+
    "\1\173\24\10\1\0\1\10\33\0\17\10\1\174\11\10"+
    "\1\0\1\10\35\0\2\160\62\0\11\10\1\175\17\10"+
    "\1\0\1\10\33\0\20\10\1\176\10\10\1\0\1\10"+
    "\33\0\15\10\1\177\13\10\1\0\1\10\33\0\12\10"+
    "\1\200\16\10\1\0\1\10\33\0\12\10\1\201\16\10"+
    "\1\0\1\10\33\0\4\10\1\202\24\10\1\0\1\10"+
    "\33\0\4\10\1\203\24\10\1\0\1\10\33\0\12\10"+
    "\1\204\16\10\1\0\1\10\33\0\27\10\1\205\1\10"+
    "\1\0\1\10\33\0\20\10\1\206\10\10\1\0\1\10"+
    "\33\0\24\10\1\207\4\10\1\0\1\10\33\0\12\10"+
    "\1\210\16\10\1\0\1\10\33\0\4\10\1\211\24\10"+
    "\1\0\1\10\33\0\27\10\1\212\1\10\1\0\1\10"+
    "\33\0\13\10\1\213\15\10\1\0\1\10\33\0\4\10"+
    "\1\214\24\10\1\0\1\10\24\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4914];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\1\1\1\11\20\1\1\11"+
    "\1\1\11\11\6\1\3\11\2\0\1\1\1\0\2\1"+
    "\1\0\23\1\7\11\1\0\22\1\1\0\21\1\1\0"+
    "\33\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
int token;
Object semanticValue;
int line(){return yyline;}
int column(){return yycolumn;}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2252) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 25: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [99] { return token=\',\'; }");
          { return token=',';
          }
        case 54: break;
        case 20: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [92] { return token=\'=\'; }");
          { return token='=';
          }
        case 55: break;
        case 46: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [51] { return token=FALSE; }");
          { return token=FALSE;
          }
        case 56: break;
        case 45: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [60] { return token=COUNT; }");
          { return token=COUNT;
          }
        case 57: break;
        case 38: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [42] { return token=LINK; }");
          { return token=LINK;
          }
        case 58: break;
        case 49: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [33] { return token=EXPLAIN; }");
          { return token=EXPLAIN;
          }
        case 59: break;
        case 5: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [68] { semanticValue=yytext();return token=IDENTIFIER; }");
          { semanticValue=yytext();return token=IDENTIFIER;
          }
        case 60: break;
        case 44: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [47] { return token=NODES; }");
          { return token=NODES;
          }
        case 61: break;
        case 9: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [71] { return token=\'+\'; }");
          { return token='+';
          }
        case 62: break;
        case 21: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [93] { return token=\'<\'; }");
          { return token='<';
          }
        case 63: break;
        case 11: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [76] { return token=\'^\'; }");
          { return token='^';
          }
        case 64: break;
        case 1: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [107] { throw new Error(\"unexpected\"+yytext()); }");
          { throw new Error("unexpected"+yytext());
          }
        case 65: break;
        case 4: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [74] { return token=\'*\'; }");
          { return token='*';
          }
        case 66: break;
        case 29: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [41] { return token=ON; }");
          { return token=ON;
          }
        case 67: break;
        case 24: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [98] { return token=\';\'; }");
          { return token=';';
          }
        case 68: break;
        case 33: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [84] { return token=AND; }");
          { return token=AND;
          }
        case 69: break;
        case 18: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [83] { return token=\'!\'; }");
          { return token='!';
          }
        case 70: break;
        case 31: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [66] { semanticValue=yytext(); return STRING_LITERAL; }");
          { semanticValue=yytext(); return STRING_LITERAL;
          }
        case 71: break;
        case 17: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [82] { return token=\']\'; }");
          { return token=']';
          }
        case 72: break;
        case 28: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [40] { return token=TO; }");
          { return token=TO;
          }
        case 73: break;
        case 13: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [78] { return token=\')\'; }");
          { return token=')';
          }
        case 74: break;
        case 23: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [97] { return token=\':\'; }");
          { return token=':';
          }
        case 75: break;
        case 32: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [88] { return token=NEQ; }");
          { return token=NEQ;
          }
        case 76: break;
        case 34: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [89] { return token=EQ; }");
          { return token=EQ;
          }
        case 77: break;
        case 52: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [48] { return token=ALL_NODES; }");
          { return token=ALL_NODES;
          }
        case 78: break;
        case 12: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [77] { return token=\'(\'; }");
          { return token='(';
          }
        case 79: break;
        case 50: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [43] { return token=FA_LINK; }");
          { return token=FA_LINK;
          }
        case 80: break;
        case 36: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [91] { return token=GEQ; }");
          { return token=GEQ;
          }
        case 81: break;
        case 16: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [81] { return token=\'[\'; }");
          { return token='[';
          }
        case 82: break;
        case 35: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [90] { return token=LEQ; }");
          { return token=LEQ;
          }
        case 83: break;
        case 41: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [35] { return token=FROM; }");
          { return token=FROM;
          }
        case 84: break;
        case 15: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [80] { return token=\'}\'; }");
          { return token='}';
          }
        case 85: break;
        case 48: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [46] { return token=BEFORE; }");
          { return token=BEFORE;
          }
        case 86: break;
        case 3: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [75] { return token=\'/\'; }");
          { return token='/';
          }
        case 87: break;
        case 42: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [37] { return token=WHEN; }");
          { return token=WHEN;
          }
        case 88: break;
        case 40: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [50] { return token=TRUE; }");
          { return token=TRUE;
          }
        case 89: break;
        case 43: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [45] { return token=AFTER; }");
          { return token=AFTER;
          }
        case 90: break;
        case 19: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [95] { return token=\'|\'; }");
          { return token='|';
          }
        case 91: break;
        case 53: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [49] { return token=SAME_NODE; }");
          { return token=SAME_NODE;
          }
        case 92: break;
        case 7: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [96] { return token=\'.\'; }");
          { return token='.';
          }
        case 93: break;
        case 47: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [34] { return token=SELECT; }");
          { return token=SELECT;
          }
        case 94: break;
        case 10: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [72] { return token=\'%\'; }");
          { return token='%';
          }
        case 95: break;
        case 14: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [79] { return token=\'{\'; }");
          { return token='{';
          }
        case 96: break;
        case 6: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [63] { semanticValue=Integer.parseInt(yytext());return token=INTEGER_LITERAL; }");
          { semanticValue=Integer.parseInt(yytext());return token=INTEGER_LITERAL;
          }
        case 97: break;
        case 8: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [73] { return token=\'-\'; }");
          { return token='-';
          }
        case 98: break;
        case 27: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [38] { return token=AT; }");
          { return token=AT;
          }
        case 99: break;
        case 37: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [59] { return token=SUM; }");
          { return token=SUM;
          }
        case 100: break;
        case 22: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [94] { return token=\'>\'; }");
          { return token='>';
          }
        case 101: break;
        case 26: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [64] { semanticValue=Double.parseDouble(yytext());return FLOAT_LITERAL; }");
          { semanticValue=Double.parseDouble(yytext());return FLOAT_LITERAL;
          }
        case 102: break;
        case 39: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [39] { return token=TIME; }");
          { return token=TIME;
          }
        case 103: break;
        case 30: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [56] { return token=OR; }");
          { return token=OR;
          }
        case 104: break;
        case 51: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [44] { return token=BETWEEN; }");
          { return token=BETWEEN;
          }
        case 105: break;
        case 2: 
          //System.out.println("match: --"+yytext()+"--");
          //System.out.println("action [105] {  }");
          { 
          }
        case 106: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {
                //System.out.println("match: <<EOF>>");
                //System.out.println("action [106] { return token=ENDINPUT; }");
                return token=ENDINPUT;
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This main method is the debugging routine for the scanner.
   * It prints debugging information about each returned token to
   * System.out until the end of file is reached, or an error occured.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      //System.out.println("Usage : java Scanner <inputfile>");
    }
    else {
      for (int i = 0; i < argv.length; i++) {
        Scanner scanner = null;
        try {
          scanner = new Scanner( new java.io.FileReader(argv[i]) );
          do {
            //System.out.println(scanner.yylex());
          } while (!scanner.zzAtEOF);

        }
        catch (java.io.FileNotFoundException e) {
          //System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          //System.out.println("IO error scanning file \""+argv[i]+"\"");
          //System.out.println(e);
        }
        catch (Exception e) {
          //System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
