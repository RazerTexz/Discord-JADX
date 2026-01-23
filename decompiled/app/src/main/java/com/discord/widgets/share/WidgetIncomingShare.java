package com.discord.widgets.share;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.ViewImageBinding;
import com.discord.databinding.WidgetIncomingShareBinding;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rest.SendUtils5;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.PaddedItemDecorator;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import com.lytefast.flexinput.model.Attachment;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p009a.ImageUploadFailedDialog;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.Tuples;
import p507d0.p512d0._Ranges;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.EmptyObservableHolder;
import p658rx.Observable;
import p658rx.functions.Action2;
import p658rx.functions.Func2;
import p658rx.functions.Func6;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetIncomingShare.class, "binding", "getBinding()Lcom/discord/databinding/WidgetIncomingShareBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_RECIPIENT = "EXTRA_RECIPIENT";
    private static final int FLIPPER_RESULTS = 0;
    private static final int FLIPPER_RESULTS_EMPTY = 1;
    private static final int FLIPPER_SEARCH = 0;
    private static final int FLIPPER_SELECTED = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> commentPublisher;
    private final BehaviorSubject<ContentModel> contentPublisher;
    private Adapter previewAdapter;
    private String queryString;
    private WidgetGlobalSearchAdapter resultsAdapter;
    private final BehaviorSubject<String> searchQueryPublisher;
    private final BehaviorSubject<WidgetGlobalSearchModel.ItemDataPayload> selectedReceiverPublisher;

    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public final class Adapter extends RecyclerView.Adapter<ViewHolder> {
        private ContentModel inputModel;
        private Function1<? super Uri, Unit> onItemClickListener;
        public final /* synthetic */ WidgetIncomingShare this$0;

        /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$Adapter$1 */
        /* JADX INFO: compiled from: WidgetIncomingShare.kt */
        public static final class C99851 extends Lambda implements Function1<Uri, Unit> {
            public static final C99851 INSTANCE = new C99851();

            public C99851() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                invoke2(uri);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Uri uri) {
            }
        }

        /* JADX INFO: compiled from: WidgetIncomingShare.kt */
        public final class ViewHolder extends RecyclerView.ViewHolder {
            private final ViewImageBinding binding;
            public final /* synthetic */ Adapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(Adapter adapter, ViewImageBinding viewImageBinding) {
                super(viewImageBinding.f15498a);
                Intrinsics3.checkNotNullParameter(viewImageBinding, "binding");
                this.this$0 = adapter;
                this.binding = viewImageBinding;
            }

            public final void bind(Uri uri) {
                this.binding.f15498a.setOnClickListener(new WidgetIncomingShare2(this, uri));
                this.binding.f15498a.setImageURI(uri);
            }
        }

        public Adapter(WidgetIncomingShare widgetIncomingShare, ContentModel contentModel, Function1<? super Uri, Unit> function1) {
            Intrinsics3.checkNotNullParameter(contentModel, "inputModel");
            Intrinsics3.checkNotNullParameter(function1, "onItemClickListener");
            this.this$0 = widgetIncomingShare;
            this.inputModel = contentModel;
            this.onItemClickListener = function1;
        }

        public static final /* synthetic */ Function1 access$getOnItemClickListener$p(Adapter adapter) {
            return adapter.onItemClickListener;
        }

        public static final /* synthetic */ void access$setOnItemClickListener$p(Adapter adapter, Function1 function1) {
            adapter.onItemClickListener = function1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: getItemCount */
        public int getPageSize() {
            List<Uri> uris = this.inputModel.getUris();
            if (uris != null) {
                return uris.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            onBindViewHolder((ViewHolder) viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void setData(ContentModel inputModel, Function1<? super Uri, Unit> onItemClickListener) {
            Intrinsics3.checkNotNullParameter(inputModel, "inputModel");
            Intrinsics3.checkNotNullParameter(onItemClickListener, "onItemClickListener");
            this.inputModel = inputModel;
            this.onItemClickListener = onItemClickListener;
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            Intrinsics3.checkNotNullParameter(holder, "holder");
            List<Uri> uris = this.inputModel.getUris();
            holder.bind(uris != null ? uris.get(position) : null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.view_image, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            ViewImageBinding viewImageBinding = new ViewImageBinding((SimpleDraweeView) viewInflate);
            Intrinsics3.checkNotNullExpressionValue(viewImageBinding, "ViewImageBinding.inflate….context), parent, false)");
            return new ViewHolder(this, viewImageBinding);
        }

        public /* synthetic */ Adapter(WidgetIncomingShare widgetIncomingShare, ContentModel contentModel, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(widgetIncomingShare, contentModel, (i & 2) != 0 ? C99851.INSTANCE : function1);
        }
    }

    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            companion.launch(context, str, str2);
        }

        public final void launch(Context context, String text, String recipient) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("android.intent.extra.TEXT", text).putExtra(WidgetIncomingShare.EXTRA_RECIPIENT, recipient);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…TRA_RECIPIENT, recipient)");
            AppScreen2.m156d(context, WidgetIncomingShare.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final /* data */ class ContentModel {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Activity activity;
        private final Uri activityActionUri;
        private final Long preselectedRecipientChannel;
        private final String recipient;
        private final CharSequence sharedText;
        private final List<Uri> uris;

        /* JADX INFO: compiled from: WidgetIncomingShare.kt */
        public static final class Companion {
            private Companion() {
            }

            public final ContentModel get(Intent recentIntent) {
                Intrinsics3.checkNotNullParameter(recentIntent, "recentIntent");
                ShareUtils.SharedContent sharedContent = ShareUtils.INSTANCE.getSharedContent(recentIntent, false);
                Long directShareId = IntentUtils.INSTANCE.getDirectShareId(recentIntent);
                String stringExtra = recentIntent.getStringExtra(WidgetIncomingShare.EXTRA_RECIPIENT);
                String action = recentIntent.getAction();
                Uri data = (action != null && action.hashCode() == -1103390587 && action.equals("com.discord.intent.action.SDK")) ? recentIntent.getData() : null;
                String stringExtra2 = recentIntent.getStringExtra("com.discord.intent.extra.EXTRA_ACTIVITY");
                return new ContentModel(sharedContent.getText(), sharedContent.getUris(), directShareId, stringExtra, data, stringExtra2 != null ? (Activity) InboundGatewayGsonParser.fromJson(new Model.JsonReader(new StringReader(stringExtra2)), Activity.class) : null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ContentModel() {
            this(null, null, null, null, null, null, 63, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ContentModel(CharSequence charSequence, List<? extends Uri> list, Long l, String str, Uri uri, Activity activity) {
            this.sharedText = charSequence;
            this.uris = list;
            this.preselectedRecipientChannel = l;
            this.recipient = str;
            this.activityActionUri = uri;
            this.activity = activity;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ContentModel copy$default(ContentModel contentModel, CharSequence charSequence, List list, Long l, String str, Uri uri, Activity activity, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = contentModel.sharedText;
            }
            if ((i & 2) != 0) {
                list = contentModel.uris;
            }
            List list2 = list;
            if ((i & 4) != 0) {
                l = contentModel.preselectedRecipientChannel;
            }
            Long l2 = l;
            if ((i & 8) != 0) {
                str = contentModel.recipient;
            }
            String str2 = str;
            if ((i & 16) != 0) {
                uri = contentModel.activityActionUri;
            }
            Uri uri2 = uri;
            if ((i & 32) != 0) {
                activity = contentModel.activity;
            }
            return contentModel.copy(charSequence, list2, l2, str2, uri2, activity);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharSequence getSharedText() {
            return this.sharedText;
        }

        public final List<Uri> component2() {
            return this.uris;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getPreselectedRecipientChannel() {
            return this.preselectedRecipientChannel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getRecipient() {
            return this.recipient;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Uri getActivityActionUri() {
            return this.activityActionUri;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        public final ContentModel copy(CharSequence sharedText, List<? extends Uri> uris, Long preselectedRecipientChannel, String recipient, Uri activityActionUri, Activity activity) {
            return new ContentModel(sharedText, uris, preselectedRecipientChannel, recipient, activityActionUri, activity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContentModel)) {
                return false;
            }
            ContentModel contentModel = (ContentModel) other;
            return Intrinsics3.areEqual(this.sharedText, contentModel.sharedText) && Intrinsics3.areEqual(this.uris, contentModel.uris) && Intrinsics3.areEqual(this.preselectedRecipientChannel, contentModel.preselectedRecipientChannel) && Intrinsics3.areEqual(this.recipient, contentModel.recipient) && Intrinsics3.areEqual(this.activityActionUri, contentModel.activityActionUri) && Intrinsics3.areEqual(this.activity, contentModel.activity);
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Uri getActivityActionUri() {
            return this.activityActionUri;
        }

        public final Long getPreselectedRecipientChannel() {
            return this.preselectedRecipientChannel;
        }

        public final String getRecipient() {
            return this.recipient;
        }

        public final CharSequence getSharedText() {
            return this.sharedText;
        }

        public final List<Uri> getUris() {
            return this.uris;
        }

        public int hashCode() {
            CharSequence charSequence = this.sharedText;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            List<Uri> list = this.uris;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            Long l = this.preselectedRecipientChannel;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            String str = this.recipient;
            int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
            Uri uri = this.activityActionUri;
            int iHashCode5 = (iHashCode4 + (uri != null ? uri.hashCode() : 0)) * 31;
            Activity activity = this.activity;
            return iHashCode5 + (activity != null ? activity.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ContentModel(sharedText=");
            sbM833U.append(this.sharedText);
            sbM833U.append(", uris=");
            sbM833U.append(this.uris);
            sbM833U.append(", preselectedRecipientChannel=");
            sbM833U.append(this.preselectedRecipientChannel);
            sbM833U.append(", recipient=");
            sbM833U.append(this.recipient);
            sbM833U.append(", activityActionUri=");
            sbM833U.append(this.activityActionUri);
            sbM833U.append(", activity=");
            sbM833U.append(this.activity);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ ContentModel(String str, List list, Long l, String str2, Uri uri, Activity activity, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : uri, (i & 32) == 0 ? activity : null);
        }
    }

    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class Model {
        private final String comment;
        private final ContentModel contentModel;
        private final ViewEmbedGameInvite.Model gameInviteModel;
        private final boolean isOnCooldown;
        private final boolean isUserPremium;
        private final int maxFileSizeMB;
        private final WidgetGlobalSearchModel.ItemDataPayload receiver;
        private final WidgetGlobalSearchModel searchModel;

        public Model(ContentModel contentModel, ViewEmbedGameInvite.Model model, String str, WidgetGlobalSearchModel widgetGlobalSearchModel, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, boolean z2, int i, boolean z3) {
            Intrinsics3.checkNotNullParameter(contentModel, "contentModel");
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchModel, "searchModel");
            this.contentModel = contentModel;
            this.gameInviteModel = model;
            this.comment = str;
            this.searchModel = widgetGlobalSearchModel;
            this.receiver = itemDataPayload;
            this.isOnCooldown = z2;
            this.maxFileSizeMB = i;
            this.isUserPremium = z3;
        }

        public final String getComment() {
            return this.comment;
        }

        public final ContentModel getContentModel() {
            return this.contentModel;
        }

        public final ViewEmbedGameInvite.Model getGameInviteModel() {
            return this.gameInviteModel;
        }

        public final int getMaxFileSizeMB() {
            return this.maxFileSizeMB;
        }

        public final WidgetGlobalSearchModel.ItemDataPayload getReceiver() {
            return this.receiver;
        }

        public final WidgetGlobalSearchModel getSearchModel() {
            return this.searchModel;
        }

        /* JADX INFO: renamed from: isOnCooldown, reason: from getter */
        public final boolean getIsOnCooldown() {
            return this.isOnCooldown;
        }

        /* JADX INFO: renamed from: isUserPremium, reason: from getter */
        public final boolean getIsUserPremium() {
            return this.isUserPremium;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$configureUi$1 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C99871 extends Lambda implements Function3<TextView, Integer, KeyEvent, Boolean> {
        public final /* synthetic */ Model $this_configureUi;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99871(Model model) {
            super(3);
            this.$this_configureUi = model;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
            return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
        }

        public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
            Intrinsics3.checkNotNullParameter(textView, "<anonymous parameter 0>");
            if (i != 4 || this.$this_configureUi.getReceiver() == null) {
                return false;
            }
            WidgetIncomingShare widgetIncomingShare = WidgetIncomingShare.this;
            TextInputLayout textInputLayout = WidgetIncomingShare.access$getBinding$p(widgetIncomingShare).f17195d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.externalShareComment");
            Context context = textInputLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.externalShareComment.context");
            WidgetIncomingShare.onSendClicked$default(widgetIncomingShare, context, this.$this_configureUi.getReceiver(), this.$this_configureUi.getGameInviteModel(), this.$this_configureUi.getContentModel(), this.$this_configureUi.getIsOnCooldown(), this.$this_configureUi.getMaxFileSizeMB(), this.$this_configureUi.getIsUserPremium(), null, 128, null);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$configureUi$2 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C99882<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Model $this_configureUi;

        public C99882(Model model) {
            this.$this_configureUi = model;
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != C5419R.id.menu_send) {
                return;
            }
            WidgetIncomingShare widgetIncomingShare = WidgetIncomingShare.this;
            Intrinsics3.checkNotNullExpressionValue(context, "ctx");
            WidgetIncomingShare.onSendClicked$default(widgetIncomingShare, context, this.$this_configureUi.getReceiver(), this.$this_configureUi.getGameInviteModel(), this.$this_configureUi.getContentModel(), this.$this_configureUi.getIsOnCooldown(), this.$this_configureUi.getMaxFileSizeMB(), this.$this_configureUi.getIsUserPremium(), null, 128, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$configureUi$5 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C99895 extends Lambda implements Function1<Uri, Unit> {
        public final /* synthetic */ ContentModel $this_configureUi;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99895(ContentModel contentModel) {
            super(1);
            this.$this_configureUi = contentModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
            invoke2(uri);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Uri uri) {
            ArrayList arrayList;
            ContentModel contentModel = this.$this_configureUi;
            List<Uri> uris = contentModel.getUris();
            if (uris != null) {
                arrayList = new ArrayList();
                for (Object obj : uris) {
                    if (!Intrinsics3.areEqual((Uri) obj, uri)) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            WidgetIncomingShare.access$getContentPublisher$p(WidgetIncomingShare.this).onNext(ContentModel.copy$default(contentModel, null, arrayList, null, null, null, null, 61, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onSendClicked$1 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C99901<T1, T2, R> implements Func2<MeUser, Channel, Tuples2<? extends MeUser, ? extends Channel>> {
        public static final C99901 INSTANCE = new C99901();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends MeUser, ? extends Channel> call(MeUser meUser, Channel channel) {
            return call2(meUser, channel);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<MeUser, Channel> call2(MeUser meUser, Channel channel) {
            return Tuples.m10073to(meUser, channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onSendClicked$2 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C99912<T, R> implements Func1<Tuples2<? extends MeUser, ? extends Channel>, Observable<? extends Tuples2<? extends MeUser, ? extends MessageQueue4>>> {
        public final /* synthetic */ CaptchaHelper.CaptchaPayload $captchaPayload;
        public final /* synthetic */ List $data;
        public final /* synthetic */ ViewEmbedGameInvite.Model $gameInviteModel;

        public C99912(List list, ViewEmbedGameInvite.Model model, CaptchaHelper.CaptchaPayload captchaPayload) {
            this.$data = list;
            this.$gameInviteModel = model;
            this.$captchaPayload = captchaPayload;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends MeUser, ? extends MessageQueue4>> call(Tuples2<? extends MeUser, ? extends Channel> tuples2) {
            return call2((Tuples2<MeUser, Channel>) tuples2);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Tuples2<MeUser, MessageQueue4>> call2(Tuples2<MeUser, Channel> tuples2) {
            MeUser meUserComponent1 = tuples2.component1();
            Channel channelComponent2 = tuples2.component2();
            if (channelComponent2 == null) {
                return EmptyObservableHolder.f26751k;
            }
            StoreMessages messages = StoreStream.INSTANCE.getMessages();
            long id2 = channelComponent2.getId();
            Intrinsics3.checkNotNullExpressionValue(meUserComponent1, "meUser");
            TextInputLayout textInputLayout = WidgetIncomingShare.access$getBinding$p(WidgetIncomingShare.this).f17195d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.externalShareComment");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            List list = this.$data;
            ViewEmbedGameInvite.Model model = this.$gameInviteModel;
            Application application = model != null ? model.getApplication() : null;
            ViewEmbedGameInvite.Model model2 = this.$gameInviteModel;
            Activity activity = model2 != null ? model2.getActivity() : null;
            ViewEmbedGameInvite.Model model3 = this.$gameInviteModel;
            return StoreMessages.sendMessage$default(messages, id2, meUserComponent1, textOrEmpty, null, list, null, null, null, application, activity, model3 != null ? model3.getMessageActivity() : null, null, null, null, this.$captchaPayload, 14464, null).m11083G(new WidgetIncomingShare6(this, meUserComponent1));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onSendClicked$3 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C99933 extends Lambda implements Function1<Tuples2<? extends MeUser, ? extends MessageQueue4>, Unit> {
        public final /* synthetic */ ContentModel $contentModel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ List $data;
        public final /* synthetic */ ViewEmbedGameInvite.Model $gameInviteModel;
        public final /* synthetic */ boolean $hasGif;
        public final /* synthetic */ boolean $hasImage;
        public final /* synthetic */ boolean $hasVideo;
        public final /* synthetic */ boolean $isOnCooldown;
        public final /* synthetic */ boolean $isUserPremium;
        public final /* synthetic */ int $maxFileSizeMB;
        public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $receiver;

        /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onSendClicked$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetIncomingShare.kt */
        public static final class AnonymousClass2 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
            public AnonymousClass2() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
                invoke2(appFragment, captchaPayload);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
                Intrinsics3.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
                Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
                C99933 c99933 = C99933.this;
                WidgetIncomingShare.access$onSendClicked(WidgetIncomingShare.this, c99933.$context, c99933.$receiver, c99933.$gameInviteModel, c99933.$contentModel, c99933.$isOnCooldown, c99933.$maxFileSizeMB, c99933.$isUserPremium, captchaPayload);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onSendClicked$3$3, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetIncomingShare.kt */
        public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ MeUser $me;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(MeUser meUser) {
                super(0);
                this.$me = meUser;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Guild guild;
                WidgetGlobalSearchModel.ItemDataPayload itemDataPayload = C99933.this.$receiver;
                int maxFileSizeMB = 0;
                if (itemDataPayload instanceof WidgetGlobalSearchModel.ItemGuild) {
                    maxFileSizeMB = GuildUtils.getMaxFileSizeMB(((WidgetGlobalSearchModel.ItemGuild) itemDataPayload).getGuild());
                } else if ((itemDataPayload instanceof WidgetGlobalSearchModel.ItemChannel) && (guild = ((WidgetGlobalSearchModel.ItemChannel) itemDataPayload).getGuild()) != null) {
                    maxFileSizeMB = GuildUtils.getMaxFileSizeMB(guild);
                }
                int iMax = Math.max(maxFileSizeMB, PremiumUtils.INSTANCE.getMaxFileSizeMB(this.$me));
                ImageUploadFailedDialog.Companion bVar = ImageUploadFailedDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetIncomingShare.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                UserUtils userUtils = UserUtils.INSTANCE;
                MeUser meUser = this.$me;
                Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                boolean zIsPremium = userUtils.isPremium(meUser);
                int size = C99933.this.$data.size();
                C99933 c99933 = C99933.this;
                bVar.m123a(parentFragmentManager, zIsPremium, iMax, Float.MAX_VALUE, Float.MAX_VALUE, null, size, c99933.$hasImage, c99933.$hasVideo, c99933.$hasGif);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99933(List list, Context context, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, ViewEmbedGameInvite.Model model, ContentModel contentModel, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6) {
            super(1);
            this.$data = list;
            this.$context = context;
            this.$receiver = itemDataPayload;
            this.$gameInviteModel = model;
            this.$contentModel = contentModel;
            this.$isOnCooldown = z2;
            this.$maxFileSizeMB = i;
            this.$isUserPremium = z3;
            this.$hasImage = z4;
            this.$hasVideo = z5;
            this.$hasGif = z6;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends MeUser, ? extends MessageQueue4> tuples2) {
            invoke2((Tuples2<MeUser, ? extends MessageQueue4>) tuples2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<MeUser, ? extends MessageQueue4> tuples2) {
            MeUser meUserComponent1 = tuples2.component1();
            MessageQueue4 messageQueue4Component2 = tuples2.component2();
            if (messageQueue4Component2 instanceof MessageQueue4.Success) {
                WidgetIncomingShare.access$onSendCompleted(WidgetIncomingShare.this);
                Attachment attachment = (Attachment) _Collections.firstOrNull(this.$data);
                if (attachment != null) {
                    AnalyticsTracker.INSTANCE.externalShare(attachment.getUri());
                    return;
                }
                return;
            }
            if (messageQueue4Component2 instanceof MessageQueue4.Slowmode) {
                int iCoerceAtLeast = _Ranges.coerceAtLeast((int) (((MessageQueue4.Slowmode) messageQueue4Component2).getCooldownMs() / 1000), 1);
                Resources resources = this.$context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
                AppToast.m170h(this.$context, StringResourceUtils.getQuantityString(resources, this.$context, C5419R.plurals.channel_slowmode_cooldown_seconds, iCoerceAtLeast, Integer.valueOf(iCoerceAtLeast)), 0, null, 12);
                return;
            }
            if (messageQueue4Component2 instanceof MessageQueue4.CaptchaRequired) {
                MessageQueue4.CaptchaRequired captchaRequired = (MessageQueue4.CaptchaRequired) messageQueue4Component2;
                if (captchaRequired.getNonce() != null) {
                    StoreStream.INSTANCE.getMessages().deleteLocalMessage(captchaRequired.getChannelId(), captchaRequired.getNonce());
                }
                WidgetCaptchaBottomSheet.Companion.enqueue$default(WidgetCaptchaBottomSheet.INSTANCE, "Message Captcha", new AnonymousClass2(), null, CaptchaErrorBody.INSTANCE.createFromError(captchaRequired.getError()), 4, null);
                return;
            }
            if (messageQueue4Component2 instanceof MessageQueue4.UnknownFailure) {
                SendUtils sendUtils = SendUtils.INSTANCE;
                Error error = ((MessageQueue4.UnknownFailure) messageQueue4Component2).getError();
                AppActivity appActivity = WidgetIncomingShare.this.getAppActivity();
                if (appActivity != null) {
                    SendUtils.handleSendError$default(sendUtils, error, appActivity, new AnonymousClass3(meUserComponent1), null, 8, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C99941 extends Lambda implements Function1<Editable, Unit> {
        public C99941() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetIncomingShare.access$getCommentPublisher$p(WidgetIncomingShare.this).onNext(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C99952 extends Lambda implements Function1<Editable, Unit> {
        public C99952() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetIncomingShare.access$getSearchQueryPublisher$p(WidgetIncomingShare.this).onNext(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class ViewOnFocusChangeListenerC99963 implements View.OnFocusChangeListener {
        public ViewOnFocusChangeListenerC99963() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z2) {
            if (z2) {
                NestedScrollView nestedScrollView = WidgetIncomingShare.access$getBinding$p(WidgetIncomingShare.this).f17201j;
                TextInputLayout textInputLayout = WidgetIncomingShare.access$getBinding$p(WidgetIncomingShare.this).f17195d;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.externalShareComment");
                nestedScrollView.smoothScrollTo(0, textInputLayout.getBottom());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class ViewOnClickListenerC99974 implements View.OnClickListener {

        /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBound$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetIncomingShare.kt */
        @DebugMetadata(m10084c = "com.discord.widgets.share.WidgetIncomingShare$onViewBound$4$1", m10085f = "WidgetIncomingShare.kt", m10086l = {Opcodes.L2D}, m10087m = "invokeSuspend")
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int label;

            public AnonymousClass1(Continuation continuation) {
                super(2, continuation);
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return ViewOnClickListenerC99974.this.new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    this.label = 1;
                    if (C3404f.m4234P(200L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                WidgetIncomingShare.access$getBinding$p(WidgetIncomingShare.this).f17198g.requestFocus();
                return Unit.f27425a;
            }
        }

        public ViewOnClickListenerC99974() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextInputLayout textInputLayout = WidgetIncomingShare.access$getBinding$p(WidgetIncomingShare.this).f17198g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.externalShareSearch");
            CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(textInputLayout);
            if (coroutineScope != null) {
                C3404f.m4211H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
            }
            WidgetIncomingShare.access$getSelectedReceiverPublisher$p(WidgetIncomingShare.this).onNext(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C99985 extends Lambda implements Function1<Intent, Unit> {
        public C99985() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
            invoke2(intent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Intent intent) {
            Intrinsics3.checkNotNullParameter(intent, "it");
            WidgetIncomingShare.access$initialize(WidgetIncomingShare.this, ContentModel.INSTANCE.get(intent));
            WidgetIncomingShare.access$getSelectedReceiverPublisher$p(WidgetIncomingShare.this).onNext(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C99991<T, R> implements Func1<WidgetGlobalSearchModel.ItemDataPayload, Observable<? extends Model>> {

        /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBoundOrOnResume$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetIncomingShare.kt */
        public static final class AnonymousClass1<T, R> implements Func1<ContentModel, Observable<? extends ViewEmbedGameInvite.Model>> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends ViewEmbedGameInvite.Model> call(ContentModel contentModel) {
                return call2(contentModel);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends ViewEmbedGameInvite.Model> call2(ContentModel contentModel) {
                return ViewEmbedGameInvite.Model.INSTANCE.getForShare(ClockFactory.get(), contentModel.getActivityActionUri(), contentModel.getActivity());
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBoundOrOnResume$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetIncomingShare.kt */
        public static final class AnonymousClass2<T, R> implements Func1<Integer, Boolean> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Integer num) {
                return call2(num);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Integer num) {
                return Boolean.valueOf(num.intValue() > 0);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBoundOrOnResume$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetIncomingShare.kt */
        public static final class AnonymousClass3<T1, T2, T3, T4, T5, T6, R> implements Func6<ContentModel, ViewEmbedGameInvite.Model, String, WidgetGlobalSearchModel, Boolean, MeUser, Model> {
            public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $receiver;

            public AnonymousClass3(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
                this.$receiver = itemDataPayload;
            }

            @Override // p658rx.functions.Func6
            public /* bridge */ /* synthetic */ Model call(ContentModel contentModel, ViewEmbedGameInvite.Model model, String str, WidgetGlobalSearchModel widgetGlobalSearchModel, Boolean bool, MeUser meUser) {
                return call2(contentModel, model, str, widgetGlobalSearchModel, bool, meUser);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Model call2(ContentModel contentModel, ViewEmbedGameInvite.Model model, String str, WidgetGlobalSearchModel widgetGlobalSearchModel, Boolean bool, MeUser meUser) {
                Guild guild;
                WidgetGlobalSearchModel.ItemDataPayload itemDataPayload = this.$receiver;
                int maxFileSizeMB = 0;
                if (itemDataPayload instanceof WidgetGlobalSearchModel.ItemGuild) {
                    maxFileSizeMB = GuildUtils.getMaxFileSizeMB(((WidgetGlobalSearchModel.ItemGuild) itemDataPayload).getGuild());
                } else if ((itemDataPayload instanceof WidgetGlobalSearchModel.ItemChannel) && (guild = ((WidgetGlobalSearchModel.ItemChannel) itemDataPayload).getGuild()) != null) {
                    maxFileSizeMB = GuildUtils.getMaxFileSizeMB(guild);
                }
                Intrinsics3.checkNotNullExpressionValue(contentModel, "contentModel");
                Intrinsics3.checkNotNullExpressionValue(widgetGlobalSearchModel, "searchModel");
                WidgetGlobalSearchModel.ItemDataPayload itemDataPayload2 = this.$receiver;
                Intrinsics3.checkNotNullExpressionValue(bool, "isOnCooldown");
                boolean zBooleanValue = bool.booleanValue();
                int iMax = Math.max(maxFileSizeMB, PremiumUtils.INSTANCE.getMaxFileSizeMB(meUser));
                UserUtils userUtils = UserUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
                return new Model(contentModel, model, str, widgetGlobalSearchModel, itemDataPayload2, zBooleanValue, iMax, userUtils.isPremium(meUser));
            }
        }

        public C99991() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Model> call(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            return call2(itemDataPayload);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Model> call2(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
            Channel channel;
            BehaviorSubject behaviorSubjectAccess$getContentPublisher$p = WidgetIncomingShare.access$getContentPublisher$p(WidgetIncomingShare.this);
            Observable<R> observableM11099Y = WidgetIncomingShare.access$getContentPublisher$p(WidgetIncomingShare.this).m11099Y(AnonymousClass1.INSTANCE);
            BehaviorSubject behaviorSubjectAccess$getCommentPublisher$p = WidgetIncomingShare.access$getCommentPublisher$p(WidgetIncomingShare.this);
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectAccess$getCommentPublisher$p, "commentPublisher");
            Observable observableLeadingEdgeThrottle = ObservableExtensionsKt.leadingEdgeThrottle(behaviorSubjectAccess$getCommentPublisher$p, 500L, TimeUnit.MILLISECONDS);
            WidgetGlobalSearchModel.Companion companion = WidgetGlobalSearchModel.INSTANCE;
            BehaviorSubject behaviorSubjectAccess$getSearchQueryPublisher$p = WidgetIncomingShare.access$getSearchQueryPublisher$p(WidgetIncomingShare.this);
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectAccess$getSearchQueryPublisher$p, "searchQueryPublisher");
            Observable forSend$default = WidgetGlobalSearchModel.Companion.getForSend$default(companion, behaviorSubjectAccess$getSearchQueryPublisher$p, null, 2, null);
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            return Observable.m11071f(behaviorSubjectAccess$getContentPublisher$p, observableM11099Y, observableLeadingEdgeThrottle, forSend$default, companion2.getSlowMode().observeCooldownSecs((itemDataPayload == null || (channel = itemDataPayload.getChannel()) == null) ? null : Long.valueOf(channel.getId()), StoreSlowMode.Type.MessageSend.INSTANCE).m11083G(AnonymousClass2.INSTANCE).m11112r(), StoreUser.observeMe$default(companion2.getUsers(), false, 1, null), new AnonymousClass3(itemDataPayload));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetIncomingShare.kt */
    public static final class C100002 extends Lambda implements Function1<Model, Unit> {
        public final /* synthetic */ Clock $clock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100002(Clock clock) {
            super(1);
            this.$clock = clock;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetIncomingShare widgetIncomingShare = WidgetIncomingShare.this;
            Intrinsics3.checkNotNullExpressionValue(model, "it");
            WidgetIncomingShare.access$configureUi(widgetIncomingShare, model, this.$clock);
        }
    }

    public WidgetIncomingShare() {
        super(C5419R.layout.widget_incoming_share);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetIncomingShare3.INSTANCE, null, 2, null);
        this.contentPublisher = BehaviorSubject.m11129k0();
        this.commentPublisher = BehaviorSubject.m11130l0("");
        this.searchQueryPublisher = BehaviorSubject.m11130l0("");
        this.selectedReceiverPublisher = BehaviorSubject.m11129k0();
    }

    public static final /* synthetic */ void access$configureUi(WidgetIncomingShare widgetIncomingShare, Model model, Clock clock) {
        widgetIncomingShare.configureUi(model, clock);
    }

    public static final /* synthetic */ WidgetIncomingShareBinding access$getBinding$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.getBinding();
    }

    public static final /* synthetic */ BehaviorSubject access$getCommentPublisher$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.commentPublisher;
    }

    public static final /* synthetic */ BehaviorSubject access$getContentPublisher$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.contentPublisher;
    }

    public static final /* synthetic */ String access$getQueryString$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.queryString;
    }

    public static final /* synthetic */ BehaviorSubject access$getSearchQueryPublisher$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.searchQueryPublisher;
    }

    public static final /* synthetic */ BehaviorSubject access$getSelectedReceiverPublisher$p(WidgetIncomingShare widgetIncomingShare) {
        return widgetIncomingShare.selectedReceiverPublisher;
    }

    public static final /* synthetic */ void access$initialize(WidgetIncomingShare widgetIncomingShare, ContentModel contentModel) {
        widgetIncomingShare.initialize(contentModel);
    }

    public static final /* synthetic */ void access$onSendClicked(WidgetIncomingShare widgetIncomingShare, Context context, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, ViewEmbedGameInvite.Model model, ContentModel contentModel, boolean z2, int i, boolean z3, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetIncomingShare.onSendClicked(context, itemDataPayload, model, contentModel, z2, i, z3, captchaPayload);
    }

    public static final /* synthetic */ void access$onSendCompleted(WidgetIncomingShare widgetIncomingShare) {
        widgetIncomingShare.onSendCompleted();
    }

    public static final /* synthetic */ void access$setQueryString$p(WidgetIncomingShare widgetIncomingShare, String str) {
        widgetIncomingShare.queryString = str;
    }

    private final void configureAdapter(Adapter previewAdapter) {
        RecyclerView recyclerView = getBinding().f17196e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.externalShareList");
        recyclerView.setAdapter(previewAdapter);
        ViewCompat.setNestedScrollingEnabled(getBinding().f17196e, false);
        getBinding().f17196e.setHasFixedSize(true);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        getBinding().f17196e.addItemDecoration(new PaddedItemDecorator(0, iDpToPixels, iDpToPixels, false, 8, null));
    }

    private final void configureUi(Model model, Clock clock) {
        List<Uri> uris;
        configureUi(model.getContentModel());
        TextInputLayout textInputLayout = getBinding().f17195d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.externalShareComment");
        ViewExtensions.setOnEditorActionListener(textInputLayout, new C99871(model));
        if (model.getReceiver() != null) {
            AppViewFlipper appViewFlipper = getBinding().f17202k;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.searchFlipper");
            appViewFlipper.setDisplayedChild(1);
            TextInputLayout textInputLayout2 = getBinding().f17198g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.externalShareSearch");
            textInputLayout2.setFocusable(false);
            TextInputLayout textInputLayout3 = getBinding().f17195d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.externalShareComment");
            EditText editText = textInputLayout3.getEditText();
            if (editText != null) {
                editText.setImeOptions(4);
            }
            String comment = model.getComment();
            setActionBarOptionsMenu(!(comment == null || StringsJVM.isBlank(comment)) || (((uris = model.getContentModel().getUris()) != null && !uris.isEmpty()) || model.getGameInviteModel() != null) ? C5419R.menu.menu_external_share : C5419R.menu.menu_empty, new C99882(model), null);
            WidgetGlobalSearchModel.ItemDataPayload receiver = model.getReceiver();
            if (receiver instanceof WidgetGlobalSearchModel.ItemUser) {
                getBinding().f17203l.onConfigure((WidgetGlobalSearchModel.ItemUser) model.getReceiver());
            } else if (receiver instanceof WidgetGlobalSearchModel.ItemChannel) {
                getBinding().f17203l.onConfigure((WidgetGlobalSearchModel.ItemChannel) model.getReceiver());
            } else if (receiver instanceof WidgetGlobalSearchModel.ItemGuild) {
                getBinding().f17203l.onConfigure((WidgetGlobalSearchModel.ItemGuild) model.getReceiver());
            }
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().f17202k;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.searchFlipper");
            appViewFlipper2.setDisplayedChild(0);
            TextInputLayout textInputLayout4 = getBinding().f17198g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.externalShareSearch");
            textInputLayout4.setFocusable(true);
            TextInputLayout textInputLayout5 = getBinding().f17198g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.externalShareSearch");
            textInputLayout5.setFocusableInTouchMode(true);
            TextInputLayout textInputLayout6 = getBinding().f17195d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.externalShareComment");
            EditText editText2 = textInputLayout6.getEditText();
            if (editText2 != null) {
                editText2.setImeOptions(5);
            }
            AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_empty, null, null, 4, null);
        }
        AppViewFlipper appViewFlipper3 = getBinding().f17200i;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.incomingShareResultsFlipper");
        appViewFlipper3.setDisplayedChild(model.getSearchModel().getData().isEmpty() ? 1 : 0);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetGlobalSearchAdapter.setOnUpdated(new WidgetIncomingShare4(this, model));
        List<WidgetGlobalSearchModel.ItemDataPayload> data = model.getSearchModel().getData();
        ArrayList arrayList = new ArrayList();
        for (Object obj : data) {
            String key = ((WidgetGlobalSearchModel.ItemDataPayload) obj).getKey();
            WidgetGlobalSearchModel.ItemDataPayload receiver2 = model.getReceiver();
            if (!Intrinsics3.areEqual(key, receiver2 != null ? receiver2.getKey() : null)) {
                arrayList.add(obj);
            }
        }
        widgetGlobalSearchAdapter.setData(arrayList);
        widgetGlobalSearchAdapter.setOnSelectedListener(new WidgetIncomingShare5(this, model));
        ViewEmbedGameInvite viewEmbedGameInvite = getBinding().f17194c;
        Intrinsics3.checkNotNullExpressionValue(viewEmbedGameInvite, "binding.externalShareActivityActionPreview");
        viewEmbedGameInvite.setVisibility(model.getGameInviteModel() != null ? 0 : 8);
        ViewEmbedGameInvite.Model gameInviteModel = model.getGameInviteModel();
        if (gameInviteModel != null) {
            getBinding().f17194c.bind(gameInviteModel, clock);
        }
    }

    private final void finish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final WidgetIncomingShareBinding getBinding() {
        return (WidgetIncomingShareBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void initialize(ContentModel contentModel) {
        Context context;
        int i = 0;
        if (contentModel.getPreselectedRecipientChannel() != null && (context = getContext()) != null) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(context, contentModel.getPreselectedRecipientChannel().longValue());
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            AppScreen2.m155c(context, false, getMostRecentIntent().setFlags(268468225), 2);
            finish();
        }
        TextInputLayout textInputLayout = getBinding().f17198g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.externalShareSearch");
        ViewExtensions.setText(textInputLayout, contentModel.getRecipient());
        TextInputLayout textInputLayout2 = getBinding().f17198g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.externalShareSearch");
        ViewExtensions.setSelectionEnd(textInputLayout2);
        TextInputLayout textInputLayout3 = getBinding().f17195d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.externalShareComment");
        ViewExtensions.setText(textInputLayout3, contentModel.getSharedText());
        this.contentPublisher.onNext(contentModel);
        List<Uri> uris = contentModel.getUris();
        if (uris != null) {
            for (Object obj : uris) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                Uri uri = (Uri) obj;
                Context context2 = getContext();
                AnalyticsTracker.addAttachment(AnalyticsTracker.ATTACHMENT_SOURCE_SHARE, AttachmentUtils.getMimeType$default(context2 != null ? context2.getContentResolver() : null, uri, null, 4, null), i);
                i = i2;
            }
        }
    }

    private final void onSendClicked(Context context, WidgetGlobalSearchModel.ItemDataPayload receiver, ViewEmbedGameInvite.Model gameInviteModel, ContentModel contentModel, boolean isOnCooldown, int maxFileSizeMB, boolean isUserPremium, CaptchaHelper.CaptchaPayload captchaPayload) {
        Observable.InterfaceC13007c interfaceC13007cM178d;
        List listEmptyList;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        if (isOnCooldown) {
            AppToast.m169g(context, C5419R.string.channel_slowmode_desc_short, 0, null, 12);
            return;
        }
        if (receiver instanceof WidgetGlobalSearchModel.ItemChannel) {
            WidgetGlobalSearchModel.ItemChannel itemChannel = (WidgetGlobalSearchModel.ItemChannel) receiver;
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), itemChannel.getChannel(), null, null, 6, null);
            interfaceC13007cM178d = C0879o.m178d(new WidgetIncomingShare7(receiver), itemChannel.getChannel(), 0L, null, 12);
        } else if (receiver instanceof WidgetGlobalSearchModel.ItemUser) {
            ChannelSelector.INSTANCE.getInstance().findAndSetDirectMessage(context, ((WidgetGlobalSearchModel.ItemUser) receiver).getUser().getId());
            interfaceC13007cM178d = C0879o.m178d(new WidgetIncomingShare8(receiver), receiver.getChannel(), 0L, null, 12);
        } else {
            if (!(receiver instanceof WidgetGlobalSearchModel.ItemGuild)) {
                return;
            }
            StoreStream.INSTANCE.getGuildSelected().set(((WidgetGlobalSearchModel.ItemGuild) receiver).getGuild().getId());
            interfaceC13007cM178d = C0879o.m178d(new WidgetIncomingShare9(receiver), receiver.getChannel(), 0L, null, 12);
        }
        List<Uri> uris = contentModel.getUris();
        if (uris != null) {
            listEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(uris, 10));
            for (Uri uri : uris) {
                Attachment.Companion companion = Attachment.INSTANCE;
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                listEmptyList.add(companion.m9296b(uri, contentResolver));
            }
        } else {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            Uri uri2 = ((Attachment) it.next()).getUri();
            ContentResolver contentResolver2 = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
            arrayList.add(Float.valueOf(SendUtils5.computeFileSizeMegabytes(uri2, contentResolver2)));
        }
        Float fM11488maxOrNull = _Collections.m11488maxOrNull((Iterable<Float>) arrayList);
        float fFloatValue = fM11488maxOrNull != null ? fM11488maxOrNull.floatValue() : 0.0f;
        float fSumOfFloat = _Collections.sumOfFloat(arrayList);
        boolean z5 = listEmptyList instanceof Collection;
        if (z5 && listEmptyList.isEmpty()) {
            z2 = false;
        } else {
            Iterator it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                if (AttachmentUtils.isImage((Attachment) it2.next(), context.getContentResolver())) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (z5 && listEmptyList.isEmpty()) {
            z3 = false;
        } else {
            Iterator it3 = listEmptyList.iterator();
            while (it3.hasNext()) {
                if (AttachmentUtils.isVideo((Attachment) it3.next(), context.getContentResolver())) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        if (z5 && listEmptyList.isEmpty()) {
            i = maxFileSizeMB;
            z4 = false;
        } else {
            Iterator it4 = listEmptyList.iterator();
            while (it4.hasNext()) {
                if (AttachmentUtils.isGif((Attachment) it4.next(), context.getContentResolver())) {
                    i = maxFileSizeMB;
                    z4 = true;
                    break;
                }
            }
            i = maxFileSizeMB;
            z4 = false;
        }
        if (fSumOfFloat > ((float) i)) {
            ImageUploadFailedDialog.Companion bVar = ImageUploadFailedDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            bVar.m123a(parentFragmentManager, isUserPremium, maxFileSizeMB, fFloatValue, fSumOfFloat, null, listEmptyList.size(), z2, z3, z4);
            return;
        }
        StoreStream.Companion companion2 = StoreStream.INSTANCE;
        Observable observableObserveMe$default = StoreUser.observeMe$default(companion2.getUsers(), false, 1, null);
        Observable<R> observableM11108k = companion2.getChannelsSelected().observeSelectedChannel().m11108k(interfaceC13007cM178d);
        Intrinsics3.checkNotNullExpressionValue(observableM11108k, "StoreStream\n            …         .compose(filter)");
        Observable observableM11082A = Observable.m11076j(observableObserveMe$default, ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11108k, 1000L, false, 2, null), C99901.INSTANCE).m11100Z(1).m11082A(new C99912(listEmptyList, gameInviteModel, captchaPayload));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "Observable\n        .comb…ervable.empty()\n        }");
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.m8519ui(observableM11082A, this, widgetGlobalSearchAdapter), getBinding().f17193b, 0L), WidgetIncomingShare.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C99933(listEmptyList, context, receiver, gameInviteModel, contentModel, isOnCooldown, maxFileSizeMB, isUserPremium, z2, z3, z4), 62, (Object) null);
    }

    public static /* synthetic */ void onSendClicked$default(WidgetIncomingShare widgetIncomingShare, Context context, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, ViewEmbedGameInvite.Model model, ContentModel contentModel, boolean z2, int i, boolean z3, CaptchaHelper.CaptchaPayload captchaPayload, int i2, Object obj) {
        widgetIncomingShare.onSendClicked(context, itemDataPayload, model, contentModel, z2, i, z3, (i2 & 128) != 0 ? null : captchaPayload);
    }

    private final void onSendCompleted() {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "this.context ?: return");
            if (!Intrinsics3.areEqual(getMostRecentIntent().getAction(), "com.discord.intent.action.SDK") && getMostRecentIntent().getBooleanExtra("com.discord.intent.extra.EXTRA_CONTINUE_IN_APP", true)) {
                AppScreen2.m155c(context, false, new Intent().addFlags(268468224), 2);
            }
            finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Context context = getContext();
        if (context == null) {
            finish();
            return;
        }
        Adapter adapter = new Adapter(this, new ContentModel(null, null, null, null, null, null, 63, null), null, 2, null);
        this.previewAdapter = adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("previewAdapter");
        }
        configureAdapter(adapter);
        TextInputLayout textInputLayout = getBinding().f17195d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.externalShareComment");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C99941());
        RecyclerView recyclerView = getBinding().f17199h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.externalShareSearchResults");
        this.resultsAdapter = (WidgetGlobalSearchAdapter) MGRecyclerAdapter.INSTANCE.configure(new WidgetGlobalSearchAdapter(recyclerView));
        ViewCompat.setNestedScrollingEnabled(getBinding().f17199h, false);
        getBinding().f17199h.setHasFixedSize(false);
        TextInputLayout textInputLayout2 = getBinding().f17198g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.externalShareSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C99952());
        TextInputLayout textInputLayout3 = getBinding().f17198g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.externalShareSearch");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout3, new ViewOnFocusChangeListenerC99963());
        getBinding().f17204m.setOnClickListener(new ViewOnClickListenerC99974());
        this.selectedReceiverPublisher.onNext(null);
        AppViewFlipper appViewFlipper = getBinding().f17202k;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.searchFlipper");
        appViewFlipper.setInAnimation(AnimationUtils.loadAnimation(context, C5419R.anim.abc_grow_fade_in_from_bottom));
        AppViewFlipper appViewFlipper2 = getBinding().f17202k;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.searchFlipper");
        appViewFlipper2.setOutAnimation(AnimationUtils.loadAnimation(context, C5419R.anim.abc_shrink_fade_out_from_bottom));
        setOnNewIntentListener(new C99985());
        initialize(ContentModel.INSTANCE.get(getMostRecentIntent()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        BehaviorSubject<String> behaviorSubject = this.searchQueryPublisher;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "searchQueryPublisher");
        StoreGuilds.Actions.requestMembers(this, behaviorSubject, false);
        Clock clock = ClockFactory.get();
        Observable<R> observableM11099Y = this.selectedReceiverPublisher.m11112r().m11099Y(new C99991());
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "selectedReceiverPublishe…  )\n          }\n        }");
        Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(observableM11099Y);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8519ui(observableComputationLatest, this, widgetGlobalSearchAdapter), WidgetIncomingShare.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C100002(clock), 62, (Object) null);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void configureUi(ContentModel contentModel) {
        Adapter adapter = this.previewAdapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("previewAdapter");
        }
        adapter.setData(contentModel, new C99895(contentModel));
        Adapter adapter2 = this.previewAdapter;
        if (adapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("previewAdapter");
        }
        adapter2.notifyDataSetChanged();
        List<Uri> uris = contentModel.getUris();
        boolean z2 = (uris == null || uris.isEmpty()) ? false : true;
        CardView cardView = getBinding().f17197f;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.externalShareListWrap");
        cardView.setVisibility(z2 ? 0 : 8);
        getBinding().f17195d.setHint(z2 ? C5419R.string.add_a_comment_optional : C5419R.string.upload_area_leave_a_comment);
    }
}
