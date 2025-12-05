package p007b.p008a.p041q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Lambda;

/* compiled from: MediaSinkWantsManager.kt */
/* renamed from: b.a.q.j, reason: use source file name */
/* loaded from: classes.dex */
public final class MediaSinkWantsManager5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Long $userId;
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSinkWantsManager5(MediaSinkWantsManager mediaSinkWantsManager, Long l) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
        this.$userId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ArrayList arrayList = new ArrayList();
        MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
        Long l = mediaSinkWantsManager.f18746e;
        if (l != null) {
            if (l.longValue() != mediaSinkWantsManager.f18749h) {
                arrayList.add(l);
            }
        }
        Long l2 = this.$userId;
        if (l2 == null) {
            this.this$0.f18746e = null;
        } else if (this.this$0.f18744c.contains(l2)) {
            MediaSinkWantsManager mediaSinkWantsManager2 = this.this$0;
            Long l3 = this.$userId;
            mediaSinkWantsManager2.f18746e = l3;
            arrayList.add(l3);
        } else {
            long j = this.this$0.f18749h;
            Long l4 = this.$userId;
            if (l4 == null || j != l4.longValue()) {
                MediaSinkWantsManager mediaSinkWantsManager3 = this.this$0;
                StringBuilder sbM833U = outline.m833U("Participant not found: ");
                sbM833U.append(this.$userId);
                mediaSinkWantsManager3.m8453a(sbM833U.toString());
                return Unit.f27425a;
            }
            this.this$0.f18746e = this.$userId;
        }
        MediaSinkWantsManager mediaSinkWantsManager4 = this.this$0;
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(((Number) it.next()).longValue()));
        }
        mediaSinkWantsManager4.m8456d(arrayList2);
        return Unit.f27425a;
    }
}
