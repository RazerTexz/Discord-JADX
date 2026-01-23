package p007b.p008a.p062y;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.OverlayVoiceBubbleBinding;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.Subject;

/* JADX INFO: renamed from: b.a.y.w, reason: use source file name */
/* JADX INFO: compiled from: OverlayVoiceBubble.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayVoiceBubble2 extends OverlayBubbleWrap implements AppComponent {

    /* JADX INFO: renamed from: x */
    public static final /* synthetic */ int f2073x = 0;

    /* JADX INFO: renamed from: y */
    public final OverlayVoiceBubbleBinding f2074y;

    /* JADX INFO: renamed from: z */
    public final Subject<Void, Void> f2075z;

    /* JADX INFO: renamed from: b.a.y.w$a */
    /* JADX INFO: compiled from: OverlayVoiceBubble.kt */
    public static final class a<T, R> implements Func1<Long, Observable<? extends StoreVoiceParticipants.VoiceUser>> {

        /* JADX INFO: renamed from: j */
        public static final a f2076j = new a();

        @Override // p637j0.p641k.Func1
        public Observable<? extends StoreVoiceParticipants.VoiceUser> call(Long l) {
            Long l2 = l;
            if (l2 != null && l2.longValue() == 0) {
                return new ScalarSynchronousObservable(null);
            }
            StoreVoiceParticipants voiceParticipants = StoreStream.INSTANCE.getVoiceParticipants();
            Intrinsics3.checkNotNullExpressionValue(l2, "channelId");
            return voiceParticipants.get(l2.longValue()).m11083G(OverlayVoiceBubble.f2072j).m11112r();
        }
    }

    /* JADX INFO: renamed from: b.a.y.w$b */
    /* JADX INFO: compiled from: OverlayVoiceBubble.kt */
    public static final class b extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            StoreVoiceParticipants.VoiceUser voiceUser2 = voiceUser;
            OverlayVoiceBubble2 overlayVoiceBubble2 = OverlayVoiceBubble2.this;
            int i = OverlayVoiceBubble2.f2073x;
            if (voiceUser2 == null) {
                overlayVoiceBubble2.m392h();
            } else {
                IconUtils.setIcon$default(overlayVoiceBubble2.getImageView$app_productionGoogleRelease(), voiceUser2.getUser(), 0, null, null, voiceUser2.getGuildMember(), 28, null);
                overlayVoiceBubble2.m391g();
            }
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayVoiceBubble2(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.overlay_voice_bubble, (ViewGroup) this, false);
        addView(viewInflate);
        Objects.requireNonNull(viewInflate, "rootView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate;
        OverlayVoiceBubbleBinding overlayVoiceBubbleBinding = new OverlayVoiceBubbleBinding(simpleDraweeView, simpleDraweeView);
        Intrinsics3.checkNotNullExpressionValue(overlayVoiceBubbleBinding, "OverlayVoiceBubbleBindin…rom(context), this, true)");
        this.f2074y = overlayVoiceBubbleBinding;
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.f2075z = publishSubjectM11133k0;
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    /* JADX INFO: renamed from: a */
    public void mo389a(boolean z2) {
        m392h();
        super.mo389a(z2);
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    /* JADX INFO: renamed from: b */
    public void mo390b(View view) {
        Intrinsics3.checkNotNullParameter(view, "targetView");
        super.mo390b(view);
        m391g();
    }

    /* JADX INFO: renamed from: g */
    public final void m391g() {
        getImageView$app_productionGoogleRelease().animate().setDuration(100L).alpha(1.0f).start();
    }

    public final SimpleDraweeView getImageView$app_productionGoogleRelease() {
        SimpleDraweeView simpleDraweeView = this.f2074y.f662b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.overlayBubbleIv");
        return simpleDraweeView;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.f2075z;
    }

    /* JADX INFO: renamed from: h */
    public final void m392h() {
        getImageView$app_productionGoogleRelease().animate().setDuration(200L).alpha(0.5f).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Observable<R> observableM11099Y = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedVoiceChannelId().m11099Y(a.f2076j);
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…d()\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11099Y), this, null, 2, null), OverlayVoiceBubble2.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new b(), 60, (Object) null);
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i = getWindowLayoutParams().x;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int i2 = i > m8436e(context).centerX() ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        super.onConfigurationChanged(configuration);
        OverlayBubbleWrap.m8434c(this, i2, getWindowLayoutParams().y, null, 4, null);
        getSpringAnimationX().skipToEnd();
        getSpringAnimationY().skipToEnd();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getUnsubscribeSignal().onNext(null);
        super.onDetachedFromWindow();
    }
}
