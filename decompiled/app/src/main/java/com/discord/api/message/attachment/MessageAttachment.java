package com.discord.api.message.attachment;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: MessageAttachment.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MessageAttachment {
    public static final String SPOILER_PREFIX = "SPOILER_";
    private final String filename;
    private final Integer height;
    private final long id;
    private final String proxyUrl;
    private final long size;
    private final String url;
    private final Integer width;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getProxyUrl() {
        return this.proxyUrl;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: e */
    public final MessageAttachmentType m8068e() {
        boolean z2;
        String str = this.url;
        Locale locale = Locale.ROOT;
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<String> listM8072a = MessageAttachment2.m8072a();
        boolean z3 = true;
        if ((listM8072a instanceof Collection) && listM8072a.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = listM8072a.iterator();
            while (it.hasNext()) {
                if (Strings4.contains$default((CharSequence) lowerCase, (CharSequence) it.next(), false, 2, (Object) null)) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (z2) {
            return MessageAttachmentType.IMAGE;
        }
        List<String> listM8073b = MessageAttachment2.m8073b();
        if ((listM8073b instanceof Collection) && listM8073b.isEmpty()) {
            z3 = false;
        } else {
            Iterator<T> it2 = listM8073b.iterator();
            while (it2.hasNext()) {
                if (Strings4.contains$default((CharSequence) lowerCase, (CharSequence) it2.next(), false, 2, (Object) null)) {
                    break;
                }
            }
            z3 = false;
        }
        return z3 ? MessageAttachmentType.VIDEO : MessageAttachmentType.FILE;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageAttachment)) {
            return false;
        }
        MessageAttachment messageAttachment = (MessageAttachment) other;
        return Intrinsics3.areEqual(this.url, messageAttachment.url) && this.size == messageAttachment.size && this.id == messageAttachment.id && Intrinsics3.areEqual(this.proxyUrl, messageAttachment.proxyUrl) && Intrinsics3.areEqual(this.filename, messageAttachment.filename) && Intrinsics3.areEqual(this.width, messageAttachment.width) && Intrinsics3.areEqual(this.height, messageAttachment.height);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m8071h() {
        return StringsJVM.startsWith$default(this.filename, SPOILER_PREFIX, false, 2, null);
    }

    public int hashCode() {
        String str = this.url;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.size;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.id;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str2 = this.proxyUrl;
        int iHashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.filename;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.width;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.height;
        return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("MessageAttachment(url=");
        sbM833U.append(this.url);
        sbM833U.append(", size=");
        sbM833U.append(this.size);
        sbM833U.append(", id=");
        sbM833U.append(this.id);
        sbM833U.append(", proxyUrl=");
        sbM833U.append(this.proxyUrl);
        sbM833U.append(", filename=");
        sbM833U.append(this.filename);
        sbM833U.append(", width=");
        sbM833U.append(this.width);
        sbM833U.append(", height=");
        return outline.m818F(sbM833U, this.height, ")");
    }
}
