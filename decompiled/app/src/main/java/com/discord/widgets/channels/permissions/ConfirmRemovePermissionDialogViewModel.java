package com.discord.widgets.channels.permissions;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.channels.permissions.PermissionOwner;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ConfirmRemovePermissionDialogViewModel.kt */
/* loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialogViewModel extends AppViewModel<ViewState> {
    private final long channelId;
    private final StoreChannels channelStore;
    private final PermissionOwner permissionOwner;

    /* compiled from: ConfirmRemovePermissionDialogViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: ConfirmRemovePermissionDialogViewModel.kt */
        public static final class Complete extends ViewState {
            public static final Complete INSTANCE = new Complete();

            private Complete() {
                super(null);
            }
        }

        /* compiled from: ConfirmRemovePermissionDialogViewModel.kt */
        public static final /* data */ class Default extends ViewState {
            private final boolean isSubmitting;

            public Default(boolean z2) {
                super(null);
                this.isSubmitting = z2;
            }

            public static /* synthetic */ Default copy$default(Default r0, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = r0.isSubmitting;
                }
                return r0.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsSubmitting() {
                return this.isSubmitting;
            }

            public final Default copy(boolean isSubmitting) {
                return new Default(isSubmitting);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Default) && this.isSubmitting == ((Default) other).isSubmitting;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isSubmitting;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isSubmitting() {
                return this.isSubmitting;
            }

            public String toString() {
                return outline.m827O(outline.m833U("Default(isSubmitting="), this.isSubmitting, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ConfirmRemovePermissionDialogViewModel.kt */
    /* renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialogViewModel$submit$1 */
    public static final class C75221 extends Lambda implements Function1<Void, Unit> {
        public C75221() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            ConfirmRemovePermissionDialogViewModel.access$handleSubmissionComplete(ConfirmRemovePermissionDialogViewModel.this);
        }
    }

    public /* synthetic */ ConfirmRemovePermissionDialogViewModel(PermissionOwner permissionOwner, long j, StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(permissionOwner, j, (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels);
    }

    public static final /* synthetic */ void access$handleSubmissionComplete(ConfirmRemovePermissionDialogViewModel confirmRemovePermissionDialogViewModel) {
        confirmRemovePermissionDialogViewModel.handleSubmissionComplete();
    }

    private final PermissionOverwrite getNewPermissionOverwrite() {
        List<PermissionOverwrite> listEmptyList;
        PermissionOverwrite.Type type;
        Object next;
        Channel channel = this.channelStore.getChannel(this.channelId);
        if (channel == null || (listEmptyList = channel.m7655v()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        PermissionOwner permissionOwner = this.permissionOwner;
        if (permissionOwner instanceof PermissionOwner.Role) {
            type = PermissionOverwrite.Type.ROLE;
        } else {
            if (!(permissionOwner instanceof PermissionOwner.Member)) {
                throw new NoWhenBranchMatchedException();
            }
            type = PermissionOverwrite.Type.MEMBER;
        }
        Iterator<T> it = listEmptyList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            PermissionOverwrite permissionOverwrite = (PermissionOverwrite) next;
            if (permissionOverwrite.getType() == type && permissionOverwrite.m8131e() == this.permissionOwner.getEntityId()) {
                break;
            }
        }
        PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) next;
        if (permissionOverwrite2 == null) {
            return null;
        }
        PermissionOverwrite permissionOverwriteM8127b = PermissionOverwrite.m8127b(permissionOverwrite2, 0L, null, (-20971537) & permissionOverwrite2.getAllow(), 0L, 11);
        if (permissionOverwriteM8127b.getAllow() == 0 && permissionOverwriteM8127b.getDeny() == 0) {
            return null;
        }
        return permissionOverwriteM8127b;
    }

    private final void handleSubmissionComplete() {
        updateViewState(ViewState.Complete.INSTANCE);
    }

    public final void submit() {
        updateViewState(new ViewState.Default(true));
        PermissionOverwrite newPermissionOverwrite = getNewPermissionOverwrite();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(newPermissionOverwrite != null ? RestAPI.INSTANCE.getApi().updatePermissionOverwrites(this.channelId, newPermissionOverwrite.m8131e(), RestAPIParams.ChannelPermissionOverwrites.INSTANCE.fromPermissionOverwrite(newPermissionOverwrite)) : RestAPI.INSTANCE.getApi().deletePermissionOverwrites(this.channelId, this.permissionOwner.getEntityId()), false, 1, null), this, null, 2, null), ConfirmRemovePermissionDialogViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75221(), 62, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmRemovePermissionDialogViewModel(PermissionOwner permissionOwner, long j, StoreChannels storeChannels) {
        super(new ViewState.Default(false));
        Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelStore");
        this.permissionOwner = permissionOwner;
        this.channelId = j;
        this.channelStore = storeChannels;
    }
}
