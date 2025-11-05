package com.discord.utilities.media;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.g;
import d0.k;
import d0.l;
import d0.z.d.m;
import d0.z.d.o;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: AppSoundManager.kt */
/* loaded from: classes2.dex */
public final class AppSoundManager {
    private final Context context;
    private Map<Integer, SoundPlayer> soundPlayers;

    /* compiled from: AppSoundManager.kt */
    public static final class Provider {
        public static final Provider INSTANCE = new Provider();

        /* renamed from: INSTANCE$delegate, reason: from kotlin metadata */
        private static final Lazy INSTANCE = g.lazy(AppSoundManager$Provider$INSTANCE$2.INSTANCE);

        private Provider() {
        }

        private final AppSoundManager getINSTANCE() {
            return (AppSoundManager) INSTANCE.getValue();
        }

        public final AppSoundManager get() {
            return getINSTANCE();
        }
    }

    /* compiled from: AppSoundManager.kt */
    public static final class SoundPlayer {
        private MediaPlayer mediaPlayer;

        public SoundPlayer(Context context, AppSound appSound, Function0<Unit> function0) throws IllegalStateException, Resources.NotFoundException, IOException, IllegalArgumentException {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(appSound, "sound");
            m.checkNotNullParameter(function0, "onCompletion");
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(appSound.getContentType()).setUsage(appSound.getUsage()).build());
                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(appSound.getResId());
                m.checkNotNullExpressionValue(assetFileDescriptorOpenRawResourceFd, "assetFileDescriptor");
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                mediaPlayer.setLooping(appSound.getShouldLoop());
                mediaPlayer.setOnCompletionListener(new AppSoundManager$SoundPlayer$$special$$inlined$apply$lambda$1(this, appSound, context, function0));
                try {
                    mediaPlayer.prepare();
                } catch (IOException unused) {
                    this.mediaPlayer = null;
                }
            }
        }

        public final boolean isPlaying() {
            Object objM97constructorimpl;
            try {
                k.a aVar = k.j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                boolean z2 = true;
                if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                    z2 = false;
                }
                objM97constructorimpl = k.m97constructorimpl(Boolean.valueOf(z2));
            } catch (Throwable th) {
                k.a aVar2 = k.j;
                objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
            }
            Throwable thM99exceptionOrNullimpl = k.m99exceptionOrNullimpl(objM97constructorimpl);
            if (thM99exceptionOrNullimpl != null) {
                AppLog.g.w("Error checking if MediaPlayer is playing", thM99exceptionOrNullimpl);
            }
            Boolean bool = Boolean.FALSE;
            if (k.m101isFailureimpl(objM97constructorimpl)) {
                objM97constructorimpl = bool;
            }
            return ((Boolean) objM97constructorimpl).booleanValue();
        }

        public final Unit release() {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer == null) {
                return null;
            }
            mediaPlayer.release();
            return Unit.a;
        }

        public final void start() {
            Object objM97constructorimpl;
            Unit unit;
            try {
                k.a aVar = k.j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                    unit = Unit.a;
                } else {
                    unit = null;
                }
                objM97constructorimpl = k.m97constructorimpl(unit);
            } catch (Throwable th) {
                k.a aVar2 = k.j;
                objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
            }
            Throwable thM99exceptionOrNullimpl = k.m99exceptionOrNullimpl(objM97constructorimpl);
            if (thM99exceptionOrNullimpl != null) {
                Logger.e$default(AppLog.g, "Error starting MediaPlayer in invalid state", thM99exceptionOrNullimpl, null, 4, null);
            }
        }

        public final void stop() {
            Object objM97constructorimpl;
            Unit unit;
            try {
                k.a aVar = k.j;
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    unit = Unit.a;
                } else {
                    unit = null;
                }
                objM97constructorimpl = k.m97constructorimpl(unit);
            } catch (Throwable th) {
                k.a aVar2 = k.j;
                objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
            }
            Throwable thM99exceptionOrNullimpl = k.m99exceptionOrNullimpl(objM97constructorimpl);
            if (thM99exceptionOrNullimpl != null) {
                AppLog.g.w("Called stop on uninitialized MediaPlayer", thM99exceptionOrNullimpl);
            }
        }
    }

    /* compiled from: AppSoundManager.kt */
    /* renamed from: com.discord.utilities.media.AppSoundManager$play$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ AppSound $sound;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AppSound appSound) {
            super(0);
            this.$sound = appSound;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$sound.getShouldLoop()) {
                return;
            }
            AppSoundManager.this.stop(this.$sound);
        }
    }

    public AppSoundManager(Application application) {
        m.checkNotNullParameter(application, "application");
        this.context = application;
        this.soundPlayers = new LinkedHashMap();
    }

    public final boolean isPlaying(AppSound sound) {
        m.checkNotNullParameter(sound, "sound");
        return this.soundPlayers.containsKey(Integer.valueOf(sound.getResId()));
    }

    public final void play(AppSound sound) {
        m.checkNotNullParameter(sound, "sound");
        if (isPlaying(sound)) {
            SoundPlayer soundPlayer = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
            if (soundPlayer != null) {
                soundPlayer.stop();
            }
            SoundPlayer soundPlayer2 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
            if (soundPlayer2 != null) {
                soundPlayer2.release();
            }
        }
        this.soundPlayers.put(Integer.valueOf(sound.getResId()), new SoundPlayer(this.context, sound, new AnonymousClass1(sound)));
        SoundPlayer soundPlayer3 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (soundPlayer3 != null) {
            soundPlayer3.start();
        }
    }

    public final void stop(AppSound sound) {
        SoundPlayer soundPlayer;
        m.checkNotNullParameter(sound, "sound");
        SoundPlayer soundPlayer2 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (soundPlayer2 != null && soundPlayer2.isPlaying() && (soundPlayer = this.soundPlayers.get(Integer.valueOf(sound.getResId()))) != null) {
            soundPlayer.stop();
        }
        SoundPlayer soundPlayer3 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (soundPlayer3 != null) {
            soundPlayer3.release();
        }
        this.soundPlayers.remove(Integer.valueOf(sound.getResId()));
    }
}
