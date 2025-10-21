package com.discord.utilities.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: NetworkMonitor.kt */
/* loaded from: classes2.dex */
public final class NetworkMonitor {
    private Logger logger;
    private final BehaviorSubject<State> networkStateSubject;

    /* compiled from: NetworkMonitor.kt */
    public enum State {
        ONLINE,
        OFFLINE,
        OFFLINE_AIRPLANE_MODE
    }

    /* compiled from: NetworkMonitor.kt */
    /* renamed from: com.discord.utilities.networking.NetworkMonitor$observeIsConnected$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<State, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(State state) {
            return call2(state);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(State state) {
            return Boolean.valueOf(state == State.ONLINE);
        }
    }

    /* compiled from: NetworkMonitor.kt */
    /* renamed from: com.discord.utilities.networking.NetworkMonitor$registerBroadcastAirplaneMode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(intent, "intent");
            Logger.i$default(NetworkMonitor.access$getLogger$p(NetworkMonitor.this), "[NetworkMonitor]", "Got airplane mode broadcast intent.", null, 4, null);
            NetworkMonitor.updateNetworkState$default(NetworkMonitor.this, context, null, 2, null);
        }
    }

    /* compiled from: NetworkMonitor.kt */
    /* renamed from: com.discord.utilities.networking.NetworkMonitor$registerBroadcastConnectivityNetworkMonitor$1, reason: invalid class name */
    public static final class AnonymousClass1 extends BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(intent, "intent");
            Logger.i$default(NetworkMonitor.access$getLogger$p(NetworkMonitor.this), "[NetworkMonitor]", "Got connectivity action broadcast intent.", null, 4, null);
            NetworkMonitor.access$updateNetworkState(NetworkMonitor.this, context, intent);
        }
    }

    /* compiled from: NetworkMonitor.kt */
    /* renamed from: com.discord.utilities.networking.NetworkMonitor$registerConnectivityNetworkMonitor$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ConnectivityManager $connectivityManager;
        public final /* synthetic */ NetworkMonitor2 $networkCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ConnectivityManager connectivityManager, NetworkMonitor2 networkMonitor2) {
            super(0);
            this.$connectivityManager = connectivityManager;
            this.$networkCallback = networkMonitor2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                this.$connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this.$networkCallback);
            } catch (Exception e) {
                NetworkMonitor.access$getLogger$p(NetworkMonitor.this).i("[NetworkMonitor]", "Unable to register network callback.", e);
            }
        }
    }

    public NetworkMonitor(Context context, Logger logger) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.networkStateSubject = BehaviorSubject.l0(getState$default(this, context, null, 2, null));
        registerConnectivityNetworkMonitor(context);
    }

    public static final /* synthetic */ Logger access$getLogger$p(NetworkMonitor networkMonitor) {
        return networkMonitor.logger;
    }

    public static final /* synthetic */ void access$setLogger$p(NetworkMonitor networkMonitor, Logger logger) {
        networkMonitor.logger = logger;
    }

    public static final /* synthetic */ void access$updateNetworkState(NetworkMonitor networkMonitor, Context context, Intent intent) {
        networkMonitor.updateNetworkState(context, intent);
    }

    private final State getState(Context context, Intent intent) {
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        State state = networkUtils.isDeviceConnected(context, intent, this.logger) ? State.ONLINE : networkUtils.isAirplaneModeOn(context) ? State.OFFLINE_AIRPLANE_MODE : State.OFFLINE;
        Logger.i$default(this.logger, "[NetworkMonitor]", "Updating network state to " + state + ", API: " + Build.VERSION.SDK_INT, null, 4, null);
        return state;
    }

    public static /* synthetic */ State getState$default(NetworkMonitor networkMonitor, Context context, Intent intent, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        return networkMonitor.getState(context, intent);
    }

    private final void registerBroadcastAirplaneMode(Context context) {
        context.registerReceiver(new AnonymousClass1(), new IntentFilter("android.intent.action.AIRPLANE_MODE"));
    }

    private final void registerBroadcastConnectivityNetworkMonitor(Context context) {
        context.registerReceiver(new AnonymousClass1(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private final void registerConnectivityNetworkMonitor(Context context) {
        Object systemService = context.getSystemService("connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            systemService = null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (connectivityManager != null) {
            NetworkMonitor2 networkMonitor2 = new NetworkMonitor2(this, context);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(connectivityManager, networkMonitor2);
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    connectivityManager.registerDefaultNetworkCallback(networkMonitor2);
                } catch (Exception unused) {
                    anonymousClass1.invoke2();
                }
            } else {
                anonymousClass1.invoke2();
            }
            registerBroadcastConnectivityNetworkMonitor(context);
            registerBroadcastAirplaneMode(context);
        }
    }

    private final void updateNetworkState(Context context, Intent intent) {
        this.networkStateSubject.onNext(getState(context, intent));
    }

    public static /* synthetic */ void updateNetworkState$default(NetworkMonitor networkMonitor, Context context, Intent intent, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        networkMonitor.updateNetworkState(context, intent);
    }

    public final Observable<Boolean> observeIsConnected() {
        Observable<Boolean> observableR = observeState().G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeState().map { sta… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = this.networkStateSubject.K().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "networkStateSubject.onBa…().distinctUntilChanged()");
        return observableR;
    }
}
