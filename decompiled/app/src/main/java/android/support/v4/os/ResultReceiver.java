package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import java.util.Objects;
import x.a.b.c.a;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();
    public x.a.b.c.a j;

    public class a implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    }

    public class b extends a.AbstractBinderC0661a {
        public b() {
        }

        @Override // x.a.b.c.a
        public void r0(int i, Bundle bundle) {
            Objects.requireNonNull(ResultReceiver.this);
            ResultReceiver.this.a(i, bundle);
        }
    }

    public ResultReceiver(Parcel parcel) {
        x.a.b.c.a c0662a;
        IBinder strongBinder = parcel.readStrongBinder();
        int i = a.AbstractBinderC0661a.a;
        if (strongBinder == null) {
            c0662a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            c0662a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof x.a.b.c.a)) ? new a.AbstractBinderC0661a.C0662a(strongBinder) : (x.a.b.c.a) iInterfaceQueryLocalInterface;
        }
        this.j = c0662a;
    }

    public void a(int i, Bundle bundle) {
    }

    public void b(int i, Bundle bundle) {
        x.a.b.c.a aVar = this.j;
        if (aVar != null) {
            try {
                aVar.r0(i, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.j == null) {
                this.j = new b();
            }
            parcel.writeStrongBinder(this.j.asBinder());
        }
    }
}
