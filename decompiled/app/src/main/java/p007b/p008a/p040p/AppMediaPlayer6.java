package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import java.util.concurrent.TimeUnit;
import p007b.p008a.p040p.RxPlayerEventListener;
import p007b.p225i.p226a.p242c.SimpleExoPlayer;
import p637j0.p638j.p640b.AndroidSchedulers;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.subjects.PublishSubject;

/* compiled from: AppMediaPlayer.kt */
/* renamed from: b.a.p.e, reason: use source file name */
/* loaded from: classes.dex */
public final class AppMediaPlayer6<T> implements Action1<RxPlayerEventListener.c> {

    /* renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1584j;

    public AppMediaPlayer6(AppMediaPlayer appMediaPlayer) {
        this.f1584j = appMediaPlayer;
    }

    @Override // p658rx.functions.Action1
    public void call(RxPlayerEventListener.c cVar) {
        int i = cVar.f1595a;
        if (i == 2) {
            PublishSubject<AppMediaPlayer.Event> publishSubject = this.f1584j.eventSubject;
            publishSubject.f27650k.onNext(AppMediaPlayer.Event.C5584b.f18655a);
            return;
        }
        if (i == 3) {
            PublishSubject<AppMediaPlayer.Event> publishSubject2 = this.f1584j.eventSubject;
            publishSubject2.f27650k.onNext(AppMediaPlayer.Event.C5583a.f18654a);
            AppMediaPlayer appMediaPlayer = this.f1584j;
            Subscription subscription = appMediaPlayer.positionPollingSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            appMediaPlayer.positionPollingSubscription = Observable.m11062F(500L, 500L, TimeUnit.MILLISECONDS, appMediaPlayer.timerScheduler).m11086L().m11084J(AndroidSchedulers.m10738a()).m11097W(new AppMediaPlayer8(appMediaPlayer), new AppMediaPlayer9(appMediaPlayer));
            return;
        }
        if (i != 4) {
            return;
        }
        PublishSubject<AppMediaPlayer.Event> publishSubject3 = this.f1584j.eventSubject;
        publishSubject3.f27650k.onNext(AppMediaPlayer.Event.C5587e.f18658a);
        Subscription subscription2 = this.f1584j.positionPollingSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        AppMediaPlayer appMediaPlayer2 = this.f1584j;
        PublishSubject<AppMediaPlayer.Event> publishSubject4 = appMediaPlayer2.eventSubject;
        publishSubject4.f27650k.onNext(new AppMediaPlayer.Event.C5585c(((SimpleExoPlayer) appMediaPlayer2.exoPlayer).mo2894T()));
    }
}
