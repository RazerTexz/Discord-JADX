package p007b.p008a.p041q;

import com.discord.rtcconnection.MediaSinkWantsManager;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: MediaSinkWantsManager.kt */
/* renamed from: b.a.q.g, reason: use source file name */
/* loaded from: classes.dex */
public final class MediaSinkWantsManager2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSinkWantsManager2(MediaSinkWantsManager mediaSinkWantsManager) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
        Objects.requireNonNull(mediaSinkWantsManager);
        mediaSinkWantsManager.m8454b(new MediaSinkWantsManager4(mediaSinkWantsManager, null));
        this.this$0.f18742a.clear();
        this.this$0.f18743b.clear();
        return Unit.f27425a;
    }
}
