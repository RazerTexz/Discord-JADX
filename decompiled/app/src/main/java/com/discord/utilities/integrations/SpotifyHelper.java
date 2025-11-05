package com.discord.utilities.integrations;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityMetadata;
import com.discord.utilities.receiver.spotify.SpotifyMetadataReceiver;
import com.discord.utilities.receiver.spotify.SpotifyPlayingStateReceiver;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import d0.y.b;
import d0.z.d.m;
import d0.z.d.o;
import java.io.IOException;
import java.net.URL;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: SpotifyHelper.kt */
/* loaded from: classes2.dex */
public final class SpotifyHelper {
    public static final SpotifyHelper INSTANCE = new SpotifyHelper();
    private static final String SPOTIFY_PACKAGE_NAME = "com.spotify.music";
    private static final String SPOTIFY_UTM_PARAMS = "utm_source=discord&utm_medium=mobile";

    /* compiled from: SpotifyHelper.kt */
    /* renamed from: com.discord.utilities.integrations.SpotifyHelper$launchAlbum$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $applicationId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $sessionId;
        public final /* synthetic */ long $userId;

        /* compiled from: SpotifyHelper.kt */
        /* renamed from: com.discord.utilities.integrations.SpotifyHelper$launchAlbum$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03361 extends o implements Function1<ActivityMetadata, Unit> {
            public C03361() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityMetadata activityMetadata) {
                invoke2(activityMetadata);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityMetadata activityMetadata) {
                String albumId;
                if (activityMetadata == null || (albumId = activityMetadata.getAlbumId()) == null) {
                    return;
                }
                SpotifyHelper.access$launchSpotifyIntent(SpotifyHelper.INSTANCE, AnonymousClass1.this.$context, new Intent("android.intent.action.VIEW", Uri.parse("spotify:album:" + Uri.encode(albumId) + "?utm_source=discord&utm_medium=mobile")));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, String str, long j2, Context context) {
            super(0);
            this.$userId = j;
            this.$sessionId = str;
            this.$applicationId = j2;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getActivityMetadata(this.$userId, this.$sessionId, this.$applicationId), false, 1, null)), this.$context, "REST: Spotify GetActivityMetadata", (Function1) null, new C03361(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* compiled from: SpotifyHelper.kt */
    /* renamed from: com.discord.utilities.integrations.SpotifyHelper$openPlayStoreForSpotify$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Context $context;

        public AnonymousClass1(Context context) {
            this.$context = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.closeFinally(new URL("https://app.adjust.com/ndjczk?campaign=" + this.$context.getPackageName()).openStream(), null);
            } catch (IOException e) {
                Log.w("SPOTIFY", "Couldn't open tracking url", e);
            }
        }
    }

    private SpotifyHelper() {
    }

    public static final /* synthetic */ void access$launchSpotifyIntent(SpotifyHelper spotifyHelper, Context context, Intent intent) {
        spotifyHelper.launchSpotifyIntent(context, intent);
    }

    private final void launchSpotifyIntent(Context context, Intent intent) {
        try {
            intent.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + context.getPackageName()));
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            if (isSpotifyInstalled(context)) {
                return;
            }
            openPlayStoreForSpotify(context);
        }
    }

    public static final void registerSpotifyBroadcastReceivers(Context context) {
        m.checkNotNullParameter(context, "context");
        context.registerReceiver(new SpotifyMetadataReceiver(), new IntentFilter("com.spotify.music.metadatachanged"));
        context.registerReceiver(new SpotifyPlayingStateReceiver(), new IntentFilter("com.spotify.music.playbackstatechanged"));
    }

    private final void runIfSpotifyInstalled(Function0<Unit> action, Context context) {
        try {
            action.invoke();
        } catch (ActivityNotFoundException unused) {
            if (isSpotifyInstalled(context)) {
                return;
            }
            openPlayStoreForSpotify(context);
        }
    }

    public final boolean isSpotifyInstalled(Context context) {
        m.checkNotNullParameter(context, "context");
        try {
            context.getPackageManager().getPackageInfo(SPOTIFY_PACKAGE_NAME, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void launchAlbum(Context context, Activity activity, long userId, boolean isMe) {
        String sessionId;
        Long applicationId;
        m.checkNotNullParameter(context, "context");
        if (isMe) {
            openSpotifyApp(context);
        } else {
            if (activity == null || (sessionId = activity.getSessionId()) == null || (applicationId = activity.getApplicationId()) == null) {
                return;
            }
            runIfSpotifyInstalled(new AnonymousClass1(userId, sessionId, applicationId.longValue(), context), context);
        }
    }

    public final void launchTrack(Context context, Activity activity) {
        String syncId;
        m.checkNotNullParameter(context, "context");
        if (activity == null || (syncId = activity.getSyncId()) == null) {
            return;
        }
        INSTANCE.runIfSpotifyInstalled(new SpotifyHelper$launchTrack$$inlined$let$lambda$1(syncId, context), context);
    }

    public final void openPlayStoreForSpotify(Context context) {
        m.checkNotNullParameter(context, "context");
        new Thread(new AnonymousClass1(context)).start();
        UriHandler.handle$default(UriHandler.INSTANCE, context, "https://play.google.com/store/apps/details?id=com.spotify.music&utm_source=discord&utm_medium=mobile", false, false, null, 28, null);
    }

    public final void openSpotifyApp(Context context) {
        m.checkNotNullParameter(context, "context");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(SPOTIFY_PACKAGE_NAME);
        if (launchIntentForPackage != null) {
            context.startActivity(launchIntentForPackage);
        }
    }
}
