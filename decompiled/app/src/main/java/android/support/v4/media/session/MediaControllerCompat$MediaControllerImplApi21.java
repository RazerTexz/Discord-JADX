package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p668x.p669a.p672b.p674b.p675a.IMediaSession;
import p668x.p669a.p672b.p674b.p675a.MediaControllerCompat;

@RequiresApi(21)
/* loaded from: classes.dex */
public class MediaControllerCompat$MediaControllerImplApi21 {

    /* renamed from: a */
    public final MediaController f40a;

    /* renamed from: b */
    public final Object f41b = new Object();

    /* renamed from: c */
    @GuardedBy("mLock")
    public final List<MediaControllerCompat> f42c = new ArrayList();

    /* renamed from: d */
    public HashMap<MediaControllerCompat, BinderC0020a> f43d = new HashMap<>();

    /* renamed from: e */
    public final MediaSessionCompat.Token f44e;

    public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* renamed from: j */
        public WeakReference<MediaControllerCompat$MediaControllerImplApi21> f45j;

        public ExtraBinderRequestResultReceiver(MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21) {
            super(null);
            this.f45j = new WeakReference<>(mediaControllerCompat$MediaControllerImplApi21);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f45j.get();
            if (mediaControllerCompat$MediaControllerImplApi21 == null || bundle == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi21.f41b) {
                MediaSessionCompat.Token token = mediaControllerCompat$MediaControllerImplApi21.f44e;
                IMediaSession iMediaSessionM11356c = IMediaSession.a.m11356c(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                synchronized (token.f50j) {
                    token.f52l = iMediaSessionM11356c;
                }
                MediaSessionCompat.Token token2 = mediaControllerCompat$MediaControllerImplApi21.f44e;
                VersionedParcelable versionedParcelable = ParcelUtils.getVersionedParcelable(bundle, "android.support.v4.media.session.SESSION_TOKEN2");
                synchronized (token2.f50j) {
                    token2.f53m = versionedParcelable;
                }
                mediaControllerCompat$MediaControllerImplApi21.m33a();
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a */
    public static class BinderC0020a extends MediaControllerCompat.b {
        public BinderC0020a(MediaControllerCompat mediaControllerCompat) {
            super(mediaControllerCompat);
        }

        @Override // p668x.p669a.p672b.p674b.p675a.MediaControllerCompat.b, p668x.p669a.p672b.p674b.p675a.IMediaControllerCallback
        /* renamed from: U */
        public void mo34U(CharSequence charSequence) throws RemoteException {
            throw new AssertionError();
        }

        @Override // p668x.p669a.p672b.p674b.p675a.MediaControllerCompat.b, p668x.p669a.p672b.p674b.p675a.IMediaControllerCallback
        /* renamed from: W */
        public void mo35W() throws RemoteException {
            throw new AssertionError();
        }

        @Override // p668x.p669a.p672b.p674b.p675a.MediaControllerCompat.b, p668x.p669a.p672b.p674b.p675a.IMediaControllerCallback
        /* renamed from: X */
        public void mo36X(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            throw new AssertionError();
        }

        @Override // p668x.p669a.p672b.p674b.p675a.MediaControllerCompat.b, p668x.p669a.p672b.p674b.p675a.IMediaControllerCallback
        /* renamed from: s0 */
        public void mo37s0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            throw new AssertionError();
        }

        @Override // p668x.p669a.p672b.p674b.p675a.MediaControllerCompat.b, p668x.p669a.p672b.p674b.p675a.IMediaControllerCallback
        /* renamed from: y */
        public void mo38y(Bundle bundle) throws RemoteException {
            throw new AssertionError();
        }

        @Override // p668x.p669a.p672b.p674b.p675a.MediaControllerCompat.b, p668x.p669a.p672b.p674b.p675a.IMediaControllerCallback
        /* renamed from: z */
        public void mo39z(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            throw new AssertionError();
        }
    }

    public MediaControllerCompat$MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
        this.f44e = token;
        MediaController mediaController = new MediaController(context, (MediaSession.Token) token.f51k);
        this.f40a = mediaController;
        if (token.m46b() == null) {
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }
    }

    @GuardedBy("mLock")
    /* renamed from: a */
    public void m33a() {
        if (this.f44e.m46b() == null) {
            return;
        }
        for (MediaControllerCompat mediaControllerCompat : this.f42c) {
            BinderC0020a binderC0020a = new BinderC0020a(mediaControllerCompat);
            this.f43d.put(mediaControllerCompat, binderC0020a);
            mediaControllerCompat.f27945a = binderC0020a;
            try {
                this.f44e.m46b().mo11355k(binderC0020a);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
            }
        }
        this.f42c.clear();
    }
}
