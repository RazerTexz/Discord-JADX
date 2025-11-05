package b.a.y;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.i.a1;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* compiled from: OverlayVoiceBubble.kt */
/* loaded from: classes2.dex */
public final class w extends OverlayBubbleWrap implements AppComponent {

    /* renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f315x = 0;

    /* renamed from: y, reason: collision with root package name */
    public final a1 f316y;

    /* renamed from: z, reason: collision with root package name */
    public final Subject<Void, Void> f317z;

    /* compiled from: OverlayVoiceBubble.kt */
    public static final class a<T, R> implements j0.k.b<Long, Observable<? extends StoreVoiceParticipants.VoiceUser>> {
        public static final a j = new a();

        @Override // j0.k.b
        public Observable<? extends StoreVoiceParticipants.VoiceUser> call(Long l) {
            Long l2 = l;
            if (l2 != null && l2.longValue() == 0) {
                return new j0.l.e.k(null);
            }
            StoreVoiceParticipants voiceParticipants = StoreStream.INSTANCE.getVoiceParticipants();
            d0.z.d.m.checkNotNullExpressionValue(l2, "channelId");
            return voiceParticipants.get(l2.longValue()).G(v.j).r();
        }
    }

    /* compiled from: OverlayVoiceBubble.kt */
    public static final class b extends d0.z.d.o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            StoreVoiceParticipants.VoiceUser voiceUser2 = voiceUser;
            w wVar = w.this;
            int i = w.f315x;
            if (voiceUser2 == null) {
                wVar.h();
            } else {
                IconUtils.setIcon$default(wVar.getImageView$app_productionGoogleRelease(), voiceUser2.getUser(), 0, null, null, voiceUser2.getGuildMember(), 28, null);
                wVar.g();
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context) {
        super(context);
        d0.z.d.m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.overlay_voice_bubble, (ViewGroup) this, false);
        addView(viewInflate);
        Objects.requireNonNull(viewInflate, "rootView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate;
        a1 a1Var = new a1(simpleDraweeView, simpleDraweeView);
        d0.z.d.m.checkNotNullExpressionValue(a1Var, "OverlayVoiceBubbleBindin…rom(context), this, true)");
        this.f316y = a1Var;
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        d0.z.d.m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.f317z = publishSubjectK0;
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    public void a(boolean z2) {
        h();
        super.a(z2);
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    public void b(View view) {
        d0.z.d.m.checkNotNullParameter(view, "targetView");
        super.b(view);
        g();
    }

    public final void g() {
        getImageView$app_productionGoogleRelease().animate().setDuration(100L).alpha(1.0f).start();
    }

    public final SimpleDraweeView getImageView$app_productionGoogleRelease() {
        SimpleDraweeView simpleDraweeView = this.f316y.f74b;
        d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView, "binding.overlayBubbleIv");
        return simpleDraweeView;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.f317z;
    }

    public final void h() {
        getImageView$app_productionGoogleRelease().animate().setDuration(200L).alpha(0.5f).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Observable<R> observableY = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedVoiceChannelId().Y(a.j);
        d0.z.d.m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…d()\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableY), this, null, 2, null), w.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new b(), 60, (Object) null);
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i = getWindowLayoutParams().x;
        Context context = getContext();
        d0.z.d.m.checkNotNullExpressionValue(context, "context");
        int i2 = i > e(context).centerX() ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        super.onConfigurationChanged(configuration);
        OverlayBubbleWrap.c(this, i2, getWindowLayoutParams().y, null, 4, null);
        getSpringAnimationX().skipToEnd();
        getSpringAnimationY().skipToEnd();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getUnsubscribeSignal().onNext(null);
        super.onDetachedFromWindow();
    }
}
