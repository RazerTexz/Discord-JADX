package p659s.p660a.p666e2;

import com.discord.widgets.chat.input.MentionUtils;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: Tasks.kt */
/* renamed from: s.a.e2.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class Tasks6 extends Tasks4 {

    /* renamed from: l */
    public final Runnable f27830l;

    public Tasks6(Runnable runnable, long j, Tasks5 tasks5) {
        super(j, tasks5);
        this.f27830l = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f27830l.run();
        } finally {
            this.f27829k.mo11268f();
        }
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Task[");
        sbM833U.append(C3404f.m4284e0(this.f27830l));
        sbM833U.append(MentionUtils.MENTIONS_CHAR);
        sbM833U.append(C3404f.m4312l0(this.f27830l));
        sbM833U.append(", ");
        sbM833U.append(this.f27828j);
        sbM833U.append(", ");
        sbM833U.append(this.f27829k);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
