package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.api.report.NodeResult;
import com.discord.api.report.ReportNode;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeElementData;
import com.discord.databinding.ViewReportsMenuNodeBinding;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.ViewMobileReportBlockUserBinding;
import p007b.p008a.p025i.ViewMobileReportsChannelPreviewBinding;
import p007b.p008a.p025i.ViewMobileReportsChildBinding;
import p007b.p008a.p025i.ViewMobileReportsMulticheckItemBinding;
import p007b.p008a.p025i.WidgetChatListAdapterItemSingleLineMessagePreviewBinding;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReportsMenuNode.kt */
/* loaded from: classes2.dex */
public final class ReportsMenuNode extends ConstraintLayout {
    private final ViewReportsMenuNodeBinding binding;
    private Function0<Unit> handleBlock;
    private Function0<Unit> handleCancel;
    private Function1<? super ReportNodeBottomButton, Unit> handlePressBottomButton;
    private Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> handleSelectChild;
    private Function0<Unit> handleSubmit;
    private MobileReportsViewModel.NodeState prevViewState;

    /* compiled from: ReportsMenuNode.kt */
    /* renamed from: com.discord.widgets.mobile_reports.ReportsMenuNode$setupBlockUser$1 */
    public static final class ViewOnClickListenerC90801 implements View.OnClickListener {
        public ViewOnClickListenerC90801() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ReportsMenuNode.access$blockUserClickListener(ReportsMenuNode.this);
        }
    }

    /* compiled from: ReportsMenuNode.kt */
    /* renamed from: com.discord.widgets.mobile_reports.ReportsMenuNode$setupBottomButton$1 */
    public static final /* synthetic */ class C90811 extends FunctionReferenceImpl implements Function1<ReportNodeBottomButton, Unit> {
        public C90811(ReportsMenuNode reportsMenuNode) {
            super(1, reportsMenuNode, ReportsMenuNode.class, "bottomButtonClickListener", "bottomButtonClickListener(Lcom/discord/api/report/ReportNodeBottomButton;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportNodeBottomButton reportNodeBottomButton) {
            invoke2(reportNodeBottomButton);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReportNodeBottomButton reportNodeBottomButton) {
            Intrinsics3.checkNotNullParameter(reportNodeBottomButton, "p1");
            ReportsMenuNode.access$bottomButtonClickListener((ReportsMenuNode) this.receiver, reportNodeBottomButton);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportsMenuNode(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingM8401a = ViewReportsMenuNodeBinding.m8401a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(viewReportsMenuNodeBindingM8401a, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingM8401a;
    }

    public static final /* synthetic */ void access$blockUserClickListener(ReportsMenuNode reportsMenuNode) {
        reportsMenuNode.blockUserClickListener();
    }

    public static final /* synthetic */ void access$bottomButtonClickListener(ReportsMenuNode reportsMenuNode, ReportNodeBottomButton reportNodeBottomButton) {
        reportsMenuNode.bottomButtonClickListener(reportNodeBottomButton);
    }

    public static final /* synthetic */ void access$childClickListener(ReportsMenuNode reportsMenuNode, ReportNodeChild reportNodeChild) {
        reportsMenuNode.childClickListener(reportNodeChild);
    }

    private final void blockUserClickListener() {
        Function0<Unit> function0 = this.handleBlock;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void bottomButtonClickListener(ReportNodeBottomButton button) {
        Function0<Unit> function0;
        Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> function2;
        if ((button instanceof ReportNodeBottomButton.Done) || (button instanceof ReportNodeBottomButton.Cancel)) {
            Function0<Unit> function02 = this.handleCancel;
            if (function02 != null) {
                function02.invoke();
                return;
            }
            return;
        }
        if (!(button instanceof ReportNodeBottomButton.Next)) {
            if (!(button instanceof ReportNodeBottomButton.Submit) || (function0 = this.handleSubmit) == null) {
                return;
            }
            function0.invoke();
            return;
        }
        ReportNodeChild reportNodeChild = new ReportNodeChild("", ((ReportNodeBottomButton.Next) button).getTarget());
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (nodeState == null || (function2 = this.handleSelectChild) == null) {
            return;
        }
        function2.invoke(reportNodeChild, nodeState);
    }

    private final void childClickListener(ReportNodeChild destination) {
        Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> function2;
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (nodeState == null || (function2 = this.handleSelectChild) == null) {
            return;
        }
        function2.invoke(destination, nodeState);
    }

    private final void setupBlockUser(MobileReportsViewModel.NodeState viewState) {
        Context context;
        int i;
        MobileReportsViewModel.BlockUserElement blockUserElement = viewState.getBlockUserElement();
        ViewMobileReportBlockUserBinding viewMobileReportBlockUserBinding = this.binding.f15534f;
        Intrinsics3.checkNotNullExpressionValue(viewMobileReportBlockUserBinding, "binding.mobileReportsNodeBlockUser");
        LinearLayout linearLayout = viewMobileReportBlockUserBinding.f1102a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsNodeBlockUser.root");
        linearLayout.setVisibility(blockUserElement != null ? 0 : 8);
        if (blockUserElement == null) {
            return;
        }
        User user = blockUserElement.getUser();
        boolean zIsBlocked = blockUserElement.isBlocked();
        TextView textView = this.binding.f15534f.f1105d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mobileReportsNod…obileReportsBlockUserName");
        textView.setText(UserUtils.INSTANCE.getUserNameWithDiscriminator(user, Integer.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorHeaderSecondary)), Float.valueOf(0.8f)));
        SimpleDraweeView simpleDraweeView = this.binding.f15534f.f1103b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.mobileReportsNod…ileReportsBlockUserAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, C5419R.dimen.avatar_size_standard, null, null, null, 56, null);
        this.binding.f15534f.f1104c.setOnClickListener(new ViewOnClickListenerC90801());
        MaterialButton materialButton = this.binding.f15534f.f1104c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.mobileReportsNod…ileReportsBlockUserButton");
        ViewExtensions.setEnabledAndAlpha(materialButton, !zIsBlocked, 0.5f);
        MaterialButton materialButton2 = this.binding.f15534f.f1104c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.mobileReportsNod…ileReportsBlockUserButton");
        if (zIsBlocked) {
            context = getContext();
            i = C5419R.string.blocked;
        } else {
            context = getContext();
            i = C5419R.string.block;
        }
        materialButton2.setText(context.getString(i));
    }

    private final void setupBottomButton(MobileReportsViewModel.NodeState viewState) {
        ReportNodeBottomButton bottomButton = viewState.getBottomButton();
        MobileReportsBottomButton mobileReportsBottomButton = this.binding.f15535g;
        Intrinsics3.checkNotNullExpressionValue(mobileReportsBottomButton, "binding.mobileReportsNodeBottomButton");
        mobileReportsBottomButton.setVisibility(bottomButton != null ? 0 : 8);
        this.binding.f15535g.setup(bottomButton, viewState.getSubmitState(), new C90811(this));
    }

    private final void setupBreadCrumbs(MobileReportsViewModel.NodeState viewState) {
        MobileReportsBreadcrumbs mobileReportsBreadcrumbs = this.binding.f15536h;
        Intrinsics3.checkNotNullExpressionValue(mobileReportsBreadcrumbs, "binding.mobileReportsNodeBreadcrumbs");
        mobileReportsBreadcrumbs.setVisibility(viewState.getBreadcrumbsElement() != null ? 0 : 8);
        List<NodeResult> breadcrumbsElement = viewState.getBreadcrumbsElement();
        if (!Intrinsics3.areEqual(breadcrumbsElement, this.prevViewState != null ? r1.getBreadcrumbsElement() : null)) {
            this.binding.f15536h.setup(viewState.getBreadcrumbsElement());
        }
    }

    private final void setupChannelPreview(MobileReportsViewModel.NodeState viewState) {
        MobileReportsViewModel.ChannelPreview channelPreviewElement = viewState.getChannelPreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        ViewMobileReportsChannelPreviewBinding viewMobileReportsChannelPreviewBinding = viewReportsMenuNodeBinding.f15530b;
        if (channelPreviewElement == null) {
            MaterialCardView materialCardView = viewReportsMenuNodeBinding.f15537i;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeChannelPreview");
            materialCardView.setVisibility(8);
            return;
        }
        TextView textView = viewMobileReportsChannelPreviewBinding.f1132c;
        Intrinsics3.checkNotNullExpressionValue(textView, "kicker");
        textView.setText(channelPreviewElement.getStageInstance().getTopic());
        LinkifiedTextView linkifiedTextView = viewMobileReportsChannelPreviewBinding.f1133d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        linkifiedTextView.setText(channelPreviewElement.getGuild().getName());
        viewMobileReportsChannelPreviewBinding.f1131b.m8545a(IconUtils.getForGuild$default(channelPreviewElement.getGuild(), null, false, null, 14, null), channelPreviewElement.getGuild().getShortName());
        MaterialCardView materialCardView2 = this.binding.f15537i;
        Intrinsics3.checkNotNullExpressionValue(materialCardView2, "binding.mobileReportsNodeChannelPreview");
        materialCardView2.setVisibility(0);
    }

    private final void setupCheckbox(MobileReportsViewModel.NodeState viewState) {
        List<ReportNodeElementData> data;
        MobileReportsViewModel.CheckboxElement checkboxElement = viewState.getCheckboxElement();
        LinearLayout linearLayout = this.binding.f15533e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsMultiselect");
        linearLayout.setVisibility(checkboxElement != null ? 0 : 8);
        MobileReportsViewModel.CheckboxElement checkboxElement2 = viewState.getCheckboxElement();
        if (!Intrinsics3.areEqual(checkboxElement2, this.prevViewState != null ? r1.getCheckboxElement() : null)) {
            this.binding.f15533e.removeAllViewsInLayout();
            if (checkboxElement == null || (data = checkboxElement.getData()) == null) {
                return;
            }
            for (ReportNodeElementData reportNodeElementData : data) {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
                LinearLayout linearLayout2 = this.binding.f15533e;
                View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.view_mobile_reports_multicheck_item, (ViewGroup) linearLayout2, false);
                linearLayout2.addView(viewInflate);
                Objects.requireNonNull(viewInflate, "rootView");
                CheckedSetting checkedSetting = (CheckedSetting) viewInflate;
                Intrinsics3.checkNotNullExpressionValue(new ViewMobileReportsMulticheckItemBinding(checkedSetting), "checkbox");
                checkedSetting.setText(reportNodeElementData.getElementValue());
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "checkbox.root");
                checkedSetting.setChecked(checkboxElement.getSelections().contains(reportNodeElementData));
                checkedSetting.setOnCheckedListener(new ReportsMenuNode2(reportNodeElementData, this, checkboxElement));
            }
        }
    }

    private final void setupChildren(MobileReportsViewModel.NodeState viewState) {
        ReportNode node;
        MobileReportsViewModel.NodeState nodeState = this.prevViewState;
        if (!Intrinsics3.areEqual((nodeState == null || (node = nodeState.getNode()) == null) ? null : node.m8172b(), viewState.getNode().m8172b())) {
            LinearLayout linearLayout = this.binding.f15538j;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.mobileReportsNodeChildList");
            Iterator<View> it = androidx.core.view.ViewGroup.getChildren(linearLayout).iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(null);
            }
            this.binding.f15538j.removeAllViewsInLayout();
            for (ReportNodeChild reportNodeChild : viewState.getNode().m8172b()) {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
                LinearLayout linearLayout2 = this.binding.f15538j;
                View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.view_mobile_reports_child, (ViewGroup) linearLayout2, false);
                linearLayout2.addView(viewInflate);
                int i = C5419R.id.mobile_reports_child;
                CardView cardView = (CardView) viewInflate.findViewById(C5419R.id.mobile_reports_child);
                if (cardView != null) {
                    i = C5419R.id.mobile_reports_child_menu_title;
                    TextView textView = (TextView) viewInflate.findViewById(C5419R.id.mobile_reports_child_menu_title);
                    if (textView != null) {
                        FrameLayout frameLayout = (FrameLayout) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new ViewMobileReportsChildBinding(frameLayout, cardView, textView), "childView");
                        frameLayout.setOnClickListener(new ReportsMenuNode3(reportNodeChild, this));
                        Intrinsics3.checkNotNullExpressionValue(textView, "childView.mobileReportsChildMenuTitle");
                        textView.setText(reportNodeChild.getName());
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
            }
        }
    }

    private final void setupDirectoryServerPreview(MobileReportsViewModel.NodeState viewState) {
        MaterialCardView materialCardView = this.binding.f15539k;
        Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeDirectoryChannelPreview");
        materialCardView.setVisibility(viewState.getDirectoryServerPreviewElement() != null ? 0 : 8);
        TextView textView = this.binding.f15540l;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mobileReportsNod…ectoryChannelPreviewTitle");
        textView.setVisibility(viewState.getDirectoryServerPreviewElement() != null ? 0 : 8);
        MobileReportsViewModel.DirectoryServerPreview directoryServerPreviewElement = viewState.getDirectoryServerPreviewElement();
        if (directoryServerPreviewElement != null) {
            ViewMobileReportsChannelPreviewBinding viewMobileReportsChannelPreviewBinding = this.binding.f15531c;
            LinkifiedTextView linkifiedTextView = viewMobileReportsChannelPreviewBinding.f1133d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            linkifiedTextView.setText(directoryServerPreviewElement.getDirectoryEntry().getGuild().getName());
            TextView textView2 = viewMobileReportsChannelPreviewBinding.f1132c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "kicker");
            textView2.setText(directoryServerPreviewElement.getHub().getName());
            viewMobileReportsChannelPreviewBinding.f1131b.m8545a(IconUtils.getForGuild$default(Long.valueOf(directoryServerPreviewElement.getDirectoryEntry().getGuild().getId()), directoryServerPreviewElement.getDirectoryEntry().getGuild().getIcon(), null, false, null, 28, null), GuildUtils.computeShortName(directoryServerPreviewElement.getDirectoryEntry().getGuild().getName()));
        }
    }

    private final void setupEventPreview(MobileReportsViewModel.NodeState viewState) {
        MobileReportsViewModel.GuildScheduledEventPreview eventPreviewElement = viewState.getEventPreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        ViewMobileReportsChannelPreviewBinding viewMobileReportsChannelPreviewBinding = viewReportsMenuNodeBinding.f15530b;
        if (eventPreviewElement == null) {
            MaterialCardView materialCardView = viewReportsMenuNodeBinding.f15537i;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeChannelPreview");
            materialCardView.setVisibility(8);
            return;
        }
        TextView textView = viewMobileReportsChannelPreviewBinding.f1132c;
        Intrinsics3.checkNotNullExpressionValue(textView, "kicker");
        textView.setText(eventPreviewElement.getGuild().getName());
        LinkifiedTextView linkifiedTextView = viewMobileReportsChannelPreviewBinding.f1133d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        linkifiedTextView.setText(eventPreviewElement.getEvent().getName());
        viewMobileReportsChannelPreviewBinding.f1131b.m8545a(IconUtils.getForGuild$default(eventPreviewElement.getGuild(), null, false, null, 14, null), eventPreviewElement.getGuild().getShortName());
        MaterialCardView materialCardView2 = this.binding.f15537i;
        Intrinsics3.checkNotNullExpressionValue(materialCardView2, "binding.mobileReportsNodeChannelPreview");
        materialCardView2.setVisibility(0);
    }

    private final void setupMessagePreview(MobileReportsViewModel.NodeState viewState) {
        MobileReportsViewModel.MessagePreview messagePreviewElement = viewState.getMessagePreviewElement();
        ViewReportsMenuNodeBinding viewReportsMenuNodeBinding = this.binding;
        if (messagePreviewElement == null) {
            WidgetChatListAdapterItemSingleLineMessagePreviewBinding widgetChatListAdapterItemSingleLineMessagePreviewBinding = viewReportsMenuNodeBinding.f15532d;
            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemSingleLineMessagePreviewBinding, "mobileReportsMessagePreview");
            ConstraintLayout constraintLayout = widgetChatListAdapterItemSingleLineMessagePreviewBinding.f1444a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "mobileReportsMessagePreview.root");
            constraintLayout.setVisibility(8);
            return;
        }
        TextView textView = viewReportsMenuNodeBinding.f15532d.f1448e;
        Intrinsics3.checkNotNullExpressionValue(textView, "mobileReportsMessagePrev…atListAdapterItemTextName");
        textView.setText(messagePreviewElement.getAuthorName());
        viewReportsMenuNodeBinding.f15532d.f1448e.setTextColor(messagePreviewElement.getAuthorNameColor());
        SimpleDraweeView simpleDraweeView = viewReportsMenuNodeBinding.f15532d.f1447d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "mobileReportsMessagePrev…ListAdapterItemTextAvatar");
        IconUtils.setIcon$default(simpleDraweeView, messagePreviewElement.getAuthor(), C5419R.dimen.avatar_size_small, null, null, null, 56, null);
        viewReportsMenuNodeBinding.f15532d.f1446c.setDraweeSpanStringBuilder(messagePreviewElement.getText());
        ImageView imageView = viewReportsMenuNodeBinding.f15532d.f1445b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "mobileReportsMessagePrev…terItemChatAttachmentIcon");
        imageView.setVisibility(messagePreviewElement.getHasEmbeds() ? 0 : 8);
        WidgetChatListAdapterItemSingleLineMessagePreviewBinding widgetChatListAdapterItemSingleLineMessagePreviewBinding2 = viewReportsMenuNodeBinding.f15532d;
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemSingleLineMessagePreviewBinding2, "mobileReportsMessagePreview");
        ConstraintLayout constraintLayout2 = widgetChatListAdapterItemSingleLineMessagePreviewBinding2.f1444a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "mobileReportsMessagePreview.root");
        constraintLayout2.setVisibility(0);
    }

    private final void setupSuccess(boolean showSuccess) {
        ImageView imageView = this.binding.f15545q;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.mobileReportsNodeSuccessShield");
        imageView.setVisibility(showSuccess ? 0 : 8);
    }

    private final void setupTextElements(MobileReportsViewModel.NodeState viewState) {
        TextView textView = this.binding.f15541m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mobileReportsNodeHeader");
        textView.setText(FormatUtils.m220l(viewState.getNode().getHeader(), new Object[0], null, 2));
        String subheader = viewState.getNode().getSubheader();
        LinkifiedTextView linkifiedTextView = this.binding.f15544p;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.mobileReportsNodeSubheader");
        linkifiedTextView.setVisibility(subheader != null ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = this.binding.f15544p;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.mobileReportsNodeSubheader");
        FormatUtils.m223o(linkifiedTextView2, subheader, new Object[0], null, 4);
        String info = viewState.getNode().getInfo();
        MaterialCardView materialCardView = this.binding.f15542n;
        Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.mobileReportsNodeInfoBox");
        materialCardView.setVisibility(info != null ? 0 : 8);
        TextView textView2 = this.binding.f15543o;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.mobileReportsNodeInfoText");
        FormatUtils.m223o(textView2, info, new Object[0], null, 4);
    }

    public final Function0<Unit> getHandleBlock() {
        return this.handleBlock;
    }

    public final Function0<Unit> getHandleCancel() {
        return this.handleCancel;
    }

    public final Function1<ReportNodeBottomButton, Unit> getHandlePressBottomButton() {
        return this.handlePressBottomButton;
    }

    public final Function2<ReportNodeChild, MobileReportsViewModel.NodeState, Unit> getHandleSelectChild() {
        return this.handleSelectChild;
    }

    public final Function0<Unit> getHandleSubmit() {
        return this.handleSubmit;
    }

    /* renamed from: getViewState, reason: from getter */
    public final MobileReportsViewModel.NodeState getPrevViewState() {
        return this.prevViewState;
    }

    public final void setHandleBlock(Function0<Unit> function0) {
        this.handleBlock = function0;
    }

    public final void setHandleCancel(Function0<Unit> function0) {
        this.handleCancel = function0;
    }

    public final void setHandlePressBottomButton(Function1<? super ReportNodeBottomButton, Unit> function1) {
        this.handlePressBottomButton = function1;
    }

    public final void setHandleSelectChild(Function2<? super ReportNodeChild, ? super MobileReportsViewModel.NodeState, Unit> function2) {
        this.handleSelectChild = function2;
    }

    public final void setHandleSubmit(Function0<Unit> function0) {
        this.handleSubmit = function0;
    }

    public final void setup(MobileReportsViewModel.NodeState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        setupSuccess(viewState.getSuccessElement());
        setupMessagePreview(viewState);
        setupChannelPreview(viewState);
        setupDirectoryServerPreview(viewState);
        setupEventPreview(viewState);
        setupBreadCrumbs(viewState);
        setupTextElements(viewState);
        setupChildren(viewState);
        setupCheckbox(viewState);
        setupBottomButton(viewState);
        setupBlockUser(viewState);
        this.prevViewState = viewState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportsMenuNode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingM8401a = ViewReportsMenuNodeBinding.m8401a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(viewReportsMenuNodeBindingM8401a, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingM8401a;
    }

    public /* synthetic */ ReportsMenuNode(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public /* synthetic */ ReportsMenuNode(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportsMenuNode(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewReportsMenuNodeBinding viewReportsMenuNodeBindingM8401a = ViewReportsMenuNodeBinding.m8401a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(viewReportsMenuNodeBindingM8401a, "ViewReportsMenuNodeBindi…rom(context), this, true)");
        this.binding = viewReportsMenuNodeBindingM8401a;
    }
}
