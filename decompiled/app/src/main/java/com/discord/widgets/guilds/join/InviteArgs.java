package com.discord.widgets.guilds.join;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* loaded from: classes2.dex */
public final /* data */ class InviteArgs extends CaptchaArgs {
    private final ModelInvite invite;
    private final Class<?> javaClass;
    private final String location;
    private final Function2<ModelInvite, Continuation<? super Unit>, Object> onInviteFlowFinished;
    private final Function2<Error, Continuation<? super Unit>, Object> onInvitePostError;
    private final Function2<ModelInvite, Continuation<? super Unit>, Object> onInvitePostSuccess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InviteArgs(ModelInvite modelInvite, Class<?> cls, String str, Function2<? super Error, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> function22, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> function23) {
        super(null);
        Intrinsics3.checkNotNullParameter(modelInvite, "invite");
        Intrinsics3.checkNotNullParameter(cls, "javaClass");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(function2, "onInvitePostError");
        Intrinsics3.checkNotNullParameter(function22, "onInvitePostSuccess");
        Intrinsics3.checkNotNullParameter(function23, "onInviteFlowFinished");
        this.invite = modelInvite;
        this.javaClass = cls;
        this.location = str;
        this.onInvitePostError = function2;
        this.onInvitePostSuccess = function22;
        this.onInviteFlowFinished = function23;
    }

    public static /* synthetic */ InviteArgs copy$default(InviteArgs inviteArgs, ModelInvite modelInvite, Class cls, String str, Function2 function2, Function2 function22, Function2 function23, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = inviteArgs.invite;
        }
        if ((i & 2) != 0) {
            cls = inviteArgs.javaClass;
        }
        Class cls2 = cls;
        if ((i & 4) != 0) {
            str = inviteArgs.location;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            function2 = inviteArgs.onInvitePostError;
        }
        Function2 function24 = function2;
        if ((i & 16) != 0) {
            function22 = inviteArgs.onInvitePostSuccess;
        }
        Function2 function25 = function22;
        if ((i & 32) != 0) {
            function23 = inviteArgs.onInviteFlowFinished;
        }
        return inviteArgs.copy(modelInvite, cls2, str2, function24, function25, function23);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final Class<?> component2() {
        return this.javaClass;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public final Function2<Error, Continuation<? super Unit>, Object> component4() {
        return this.onInvitePostError;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> component5() {
        return this.onInvitePostSuccess;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> component6() {
        return this.onInviteFlowFinished;
    }

    public final InviteArgs copy(ModelInvite invite, Class<?> javaClass, String location, Function2<? super Error, ? super Continuation<? super Unit>, ? extends Object> onInvitePostError, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInvitePostSuccess, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInviteFlowFinished) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        Intrinsics3.checkNotNullParameter(javaClass, "javaClass");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(onInvitePostError, "onInvitePostError");
        Intrinsics3.checkNotNullParameter(onInvitePostSuccess, "onInvitePostSuccess");
        Intrinsics3.checkNotNullParameter(onInviteFlowFinished, "onInviteFlowFinished");
        return new InviteArgs(invite, javaClass, location, onInvitePostError, onInvitePostSuccess, onInviteFlowFinished);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteArgs)) {
            return false;
        }
        InviteArgs inviteArgs = (InviteArgs) other;
        return Intrinsics3.areEqual(this.invite, inviteArgs.invite) && Intrinsics3.areEqual(this.javaClass, inviteArgs.javaClass) && Intrinsics3.areEqual(this.location, inviteArgs.location) && Intrinsics3.areEqual(this.onInvitePostError, inviteArgs.onInvitePostError) && Intrinsics3.areEqual(this.onInvitePostSuccess, inviteArgs.onInvitePostSuccess) && Intrinsics3.areEqual(this.onInviteFlowFinished, inviteArgs.onInviteFlowFinished);
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final Class<?> getJavaClass() {
        return this.javaClass;
    }

    public final String getLocation() {
        return this.location;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> getOnInviteFlowFinished() {
        return this.onInviteFlowFinished;
    }

    public final Function2<Error, Continuation<? super Unit>, Object> getOnInvitePostError() {
        return this.onInvitePostError;
    }

    public final Function2<ModelInvite, Continuation<? super Unit>, Object> getOnInvitePostSuccess() {
        return this.onInvitePostSuccess;
    }

    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
        Class<?> cls = this.javaClass;
        int iHashCode2 = (iHashCode + (cls != null ? cls.hashCode() : 0)) * 31;
        String str = this.location;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Function2<Error, Continuation<? super Unit>, Object> function2 = this.onInvitePostError;
        int iHashCode4 = (iHashCode3 + (function2 != null ? function2.hashCode() : 0)) * 31;
        Function2<ModelInvite, Continuation<? super Unit>, Object> function22 = this.onInvitePostSuccess;
        int iHashCode5 = (iHashCode4 + (function22 != null ? function22.hashCode() : 0)) * 31;
        Function2<ModelInvite, Continuation<? super Unit>, Object> function23 = this.onInviteFlowFinished;
        return iHashCode5 + (function23 != null ? function23.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InviteArgs(invite=");
        sbU.append(this.invite);
        sbU.append(", javaClass=");
        sbU.append(this.javaClass);
        sbU.append(", location=");
        sbU.append(this.location);
        sbU.append(", onInvitePostError=");
        sbU.append(this.onInvitePostError);
        sbU.append(", onInvitePostSuccess=");
        sbU.append(this.onInvitePostSuccess);
        sbU.append(", onInviteFlowFinished=");
        sbU.append(this.onInviteFlowFinished);
        sbU.append(")");
        return sbU.toString();
    }
}
