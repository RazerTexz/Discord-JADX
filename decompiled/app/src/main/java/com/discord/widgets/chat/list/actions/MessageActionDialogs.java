package com.discord.widgets.chat.list.actions;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.chat.list.PublishActionDialog;
import com.discord.widgets.notice.WidgetNoticeDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p507d0.Tuples;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: MessageActionDialogs.kt */
/* loaded from: classes2.dex */
public final class MessageActionDialogs {
    public static final MessageActionDialogs INSTANCE = new MessageActionDialogs();

    /* compiled from: MessageActionDialogs.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.MessageActionDialogs$showDeleteMessageConfirmation$1 */
    public static final class C79581 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Message $message;
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79581(Message message, Function0 function0) {
            super(1);
            this.$message = message;
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            StoreStream.INSTANCE.getMessages().deleteMessage(this.$message);
            this.$onSuccess.invoke();
        }
    }

    /* compiled from: MessageActionDialogs.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.MessageActionDialogs$showPinMessageConfirmation$1 */
    public static final class C79591 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isPinned;
        public final /* synthetic */ Message $message;
        public final /* synthetic */ Function0 $onSuccess;

        /* compiled from: MessageActionDialogs.kt */
        /* renamed from: com.discord.widgets.chat.list.actions.MessageActionDialogs$showPinMessageConfirmation$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r5) {
                C79591 c79591 = C79591.this;
                AppToast.m169g(c79591.$context, c79591.$isPinned ? C5419R.string.message_unpinned : C5419R.string.message_pinned, 0, null, 12);
                C79591.this.$onSuccess.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79591(Message message, boolean z2, AppComponent appComponent, Context context, Function0 function0) {
            super(1);
            this.$message = message;
            this.$isPinned = z2;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            long channelId = this.$message.getChannelId();
            long id2 = this.$message.getId();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.$isPinned ? RestAPI.INSTANCE.getApi().deleteChannelPin(channelId, id2) : RestAPI.INSTANCE.getApi().addChannelPin(channelId, id2), false, 1, null), this.$appComponent, null, 2, null), MessageActionDialogs.INSTANCE.getClass(), view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
        }
    }

    private MessageActionDialogs() {
    }

    public final void showDeleteMessageConfirmation(FragmentManager fragmentManager, Context context, Message message, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = context.getString(C5419R.string.delete_message);
        String string2 = context.getString(C5419R.string.delete_message_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.delete_message_body)");
        WidgetNoticeDialog.Companion.show$default(companion, fragmentManager, string, string2, context.getString(C5419R.string.delete), context.getString(C5419R.string.cancel), MapsJVM.mapOf(Tuples.m10073to(Integer.valueOf(C5419R.id.notice_ok), new C79581(message, onSuccess))), null, null, null, Integer.valueOf(C5419R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
    }

    public final void showPinMessageConfirmation(FragmentManager fragmentManager, Context context, Message message, AppComponent appComponent, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        boolean zAreEqual = Intrinsics3.areEqual(message.getPinned(), Boolean.TRUE);
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = context.getString(zAreEqual ? C5419R.string.unpin_message_title : C5419R.string.pin_message_title);
        String string2 = context.getString(zAreEqual ? C5419R.string.unpin_message_body : C5419R.string.pin_message_body_mobile);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(\n     …age_body_mobile\n        )");
        WidgetNoticeDialog.Companion.show$default(companion, fragmentManager, string, string2, context.getString(zAreEqual ? C5419R.string.unpin : C5419R.string.pin), context.getString(C5419R.string.cancel), MapsJVM.mapOf(Tuples.m10073to(Integer.valueOf(C5419R.id.notice_ok), new C79591(message, zAreEqual, appComponent, context, onSuccess))), null, null, null, null, null, null, 0, null, 16320, null);
    }

    public final void showPublishMessageConfirmation(FragmentManager fragmentManager, Message message, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        PublishActionDialog.Companion.show$default(PublishActionDialog.INSTANCE, fragmentManager, message.getId(), message.getChannelId(), onSuccess, null, 16, null);
    }
}
