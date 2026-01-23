package p007b.p195g.p196a.p198b;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import p007b.p195g.p196a.p198b.p200p.CharTypes;

/* JADX INFO: renamed from: b.g.a.b.g, reason: use source file name */
/* JADX INFO: compiled from: JsonStreamContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonStreamContext {

    /* JADX INFO: renamed from: a */
    public int f4503a;

    /* JADX INFO: renamed from: b */
    public int f4504b;

    public JsonStreamContext() {
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo1673a();

    /* JADX INFO: renamed from: b */
    public final boolean m1674b() {
        return this.f4503a == 1;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1675c() {
        return this.f4503a == 2;
    }

    /* JADX INFO: renamed from: d */
    public abstract void mo1676d(Object obj);

    /* JADX INFO: renamed from: e */
    public String m1677e() {
        int i = this.f4503a;
        return i != 0 ? i != 1 ? i != 2 ? "?" : "Object" : "Array" : "root";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this.f4503a;
        if (i != 0) {
            if (i != 1) {
                sb.append('{');
                String strMo1673a = mo1673a();
                if (strMo1673a != null) {
                    sb.append('\"');
                    int[] iArr = CharTypes.f4541f;
                    int length = iArr.length;
                    int length2 = strMo1673a.length();
                    while (i < length2) {
                        char cCharAt = strMo1673a.charAt(i);
                        if (cCharAt >= length || iArr[cCharAt] == 0) {
                            sb.append(cCharAt);
                        } else {
                            sb.append('\\');
                            int i2 = iArr[cCharAt];
                            if (i2 < 0) {
                                sb.append('u');
                                sb.append('0');
                                sb.append('0');
                                char[] cArr = CharTypes.f4536a;
                                sb.append(cArr[cCharAt >> 4]);
                                sb.append(cArr[cCharAt & 15]);
                            } else {
                                sb.append((char) i2);
                            }
                        }
                        i++;
                    }
                    sb.append('\"');
                } else {
                    sb.append('?');
                }
                sb.append('}');
            } else {
                sb.append('[');
                int i3 = this.f4504b;
                sb.append(i3 >= 0 ? i3 : 0);
                sb.append(']');
            }
        } else {
            sb.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        }
        return sb.toString();
    }

    public JsonStreamContext(int i, int i2) {
        this.f4503a = i;
        this.f4504b = i2;
    }
}
