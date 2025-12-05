package p007b.p225i.p361c.p407x;

import com.discord.widgets.chat.input.MentionUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* compiled from: DefaultUserAgentPublisher.java */
/* renamed from: b.i.c.x.c, reason: use source file name */
/* loaded from: classes3.dex */
public class DefaultUserAgentPublisher2 implements UserAgentPublisher {

    /* renamed from: a */
    public final String f13082a;

    /* renamed from: b */
    public final GlobalLibraryVersionRegistrar f13083b;

    public DefaultUserAgentPublisher2(Set<LibraryVersion> set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.f13082a = m6845a(set);
        this.f13083b = globalLibraryVersionRegistrar;
    }

    /* renamed from: a */
    public static String m6845a(Set<LibraryVersion> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<LibraryVersion> it = set.iterator();
        while (it.hasNext()) {
            LibraryVersion next = it.next();
            sb.append(next.mo6843a());
            sb.append(MentionUtils.SLASH_CHAR);
            sb.append(next.mo6844b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // p007b.p225i.p361c.p407x.UserAgentPublisher
    public String getUserAgent() {
        Set setUnmodifiableSet;
        Set setUnmodifiableSet2;
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = this.f13083b;
        synchronized (globalLibraryVersionRegistrar.f13085b) {
            setUnmodifiableSet = Collections.unmodifiableSet(globalLibraryVersionRegistrar.f13085b);
        }
        if (setUnmodifiableSet.isEmpty()) {
            return this.f13082a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13082a);
        sb.append(' ');
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar2 = this.f13083b;
        synchronized (globalLibraryVersionRegistrar2.f13085b) {
            setUnmodifiableSet2 = Collections.unmodifiableSet(globalLibraryVersionRegistrar2.f13085b);
        }
        sb.append(m6845a(setUnmodifiableSet2));
        return sb.toString();
    }
}
