package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RestCallState.kt */
/* renamed from: com.discord.stores.utilities.Failure, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class RestCallState3<T> extends RestCallState<T> {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestCallState3(Error error) {
        super(null);
        Intrinsics3.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ RestCallState3 copy$default(RestCallState3 restCallState3, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = restCallState3.error;
        }
        return restCallState3.copy(error);
    }

    /* renamed from: component1, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final RestCallState3<T> copy(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        return new RestCallState3<>(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RestCallState3) && Intrinsics3.areEqual(this.error, ((RestCallState3) other).error);
        }
        return true;
    }

    public final Error getError() {
        return this.error;
    }

    public int hashCode() {
        Error error = this.error;
        if (error != null) {
            return error.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Failure(error=");
        sbM833U.append(this.error);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
