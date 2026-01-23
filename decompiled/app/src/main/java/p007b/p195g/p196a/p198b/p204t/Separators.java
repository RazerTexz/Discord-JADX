package p007b.p195g.p196a.p198b.p204t;

import com.discord.widgets.chat.input.MentionUtils;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.b.t.j, reason: use source file name */
/* JADX INFO: compiled from: Separators.java */
/* JADX INFO: loaded from: classes3.dex */
public class Separators implements Serializable {
    private static final long serialVersionUID = 1;
    private final char objectFieldValueSeparator = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
    private final char objectEntrySeparator = ',';
    private final char arrayValueSeparator = ',';

    /* JADX INFO: renamed from: a */
    public char m1736a() {
        return this.arrayValueSeparator;
    }

    /* JADX INFO: renamed from: b */
    public char m1737b() {
        return this.objectEntrySeparator;
    }

    /* JADX INFO: renamed from: c */
    public char m1738c() {
        return this.objectFieldValueSeparator;
    }
}
