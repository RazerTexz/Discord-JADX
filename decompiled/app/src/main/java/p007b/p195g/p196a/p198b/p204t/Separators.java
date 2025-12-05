package p007b.p195g.p196a.p198b.p204t;

import com.discord.widgets.chat.input.MentionUtils;
import java.io.Serializable;

/* compiled from: Separators.java */
/* renamed from: b.g.a.b.t.j, reason: use source file name */
/* loaded from: classes3.dex */
public class Separators implements Serializable {
    private static final long serialVersionUID = 1;
    private final char objectFieldValueSeparator = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
    private final char objectEntrySeparator = ',';
    private final char arrayValueSeparator = ',';

    /* renamed from: a */
    public char m1736a() {
        return this.arrayValueSeparator;
    }

    /* renamed from: b */
    public char m1737b() {
        return this.objectEntrySeparator;
    }

    /* renamed from: c */
    public char m1738c() {
        return this.objectFieldValueSeparator;
    }
}
