package b.e.a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Date;

/* compiled from: Log.java */
/* loaded from: classes.dex */
public class a {
    public static C0064a a = new C0064a();

    /* compiled from: Log.java */
    /* renamed from: b.e.a.a$a, reason: collision with other inner class name */
    public static class C0064a {
        public long a = new Date().getTime();

        public void a(int i, String str, String str2, Throwable th) {
            StringBuilder sb = new StringBuilder(256);
            long time = new Date().getTime() - this.a;
            long j = time / 60000;
            long j2 = (time / 1000) % 60;
            if (j <= 9) {
                sb.append('0');
            }
            sb.append(j);
            sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            if (j2 <= 9) {
                sb.append('0');
            }
            sb.append(j2);
            if (i == 1) {
                sb.append(" TRACE: ");
            } else if (i == 2) {
                sb.append(" DEBUG: ");
            } else if (i == 3) {
                sb.append("  INFO: ");
            } else if (i == 4) {
                sb.append("  WARN: ");
            } else if (i == 5) {
                sb.append(" ERROR: ");
            }
            if (str != null) {
                sb.append('[');
                sb.append(str);
                sb.append("] ");
            }
            sb.append(str2);
            System.out.println(sb.toString());
        }
    }
}
