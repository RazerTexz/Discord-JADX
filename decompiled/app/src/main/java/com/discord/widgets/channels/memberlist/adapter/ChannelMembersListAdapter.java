package com.discord.widgets.channels.memberlist.adapter;

import a0.a.a.b;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import com.discord.databinding.WidgetChannelMembersListItemLoadingBinding;
import com.discord.databinding.WidgetChannelMembersListItemPlaceholderHeaderBinding;
import com.discord.databinding.WidgetChannelMembersListItemUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.views.StatusView;
import com.discord.views.UsernameView;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.roles.RoleIconView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* compiled from: ChannelMembersListAdapter.kt */
/* loaded from: classes2.dex */
public final class ChannelMembersListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyHeaderItemDecoration.StickyHeaderAdapter {
    private WidgetChannelMembersListViewModel.MemberList memberList;
    private Function0<Unit> onAddMemberClicked;
    private Function0<Unit> onJoinLeaveThreadClicked;
    private Function1<? super Long, Unit> onUserClicked;
    private StickyHeadersManager stickyHeadersManager;
    private final PublishSubject<ListUpdateRequest> updatesSubject;
    private Subscription updatesSubscription;

    /* compiled from: ChannelMembersListAdapter.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<ListUpdateRequest, ListUpdateRequest, ListUpdateOperation> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ ListUpdateOperation invoke(ListUpdateRequest listUpdateRequest, ListUpdateRequest listUpdateRequest2) {
            return invoke2(listUpdateRequest, listUpdateRequest2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ListUpdateOperation invoke2(ListUpdateRequest listUpdateRequest, ListUpdateRequest listUpdateRequest2) {
            m.checkNotNullParameter(listUpdateRequest, "prevRequest");
            m.checkNotNullParameter(listUpdateRequest2, "nextRequest");
            if (listUpdateRequest2.getForceOverwrite()) {
                return new ListUpdateOperation.OverwriteUpdate(listUpdateRequest2);
            }
            String listId = listUpdateRequest.getListId();
            WidgetChannelMembersListViewModel.MemberList rows = listUpdateRequest.getRows();
            String listId2 = listUpdateRequest2.getListId();
            WidgetChannelMembersListViewModel.MemberList rows2 = listUpdateRequest2.getRows();
            if (!m.areEqual(listId, listId2) || Math.abs(rows.getSize() - rows2.getSize()) >= 255) {
                return new ListUpdateOperation.OverwriteUpdate(listUpdateRequest2);
            }
            DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtilCallback(rows, rows2));
            m.checkNotNullExpressionValue(diffResultCalculateDiff, "DiffUtil.calculateDiff(diffUtilCallback)");
            return new ListUpdateOperation.DiffUpdate(diffResultCalculateDiff, listUpdateRequest2);
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<ListUpdateOperation, ListUpdateRequest, ListUpdateOperation> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ ListUpdateOperation call(ListUpdateOperation listUpdateOperation, ListUpdateRequest listUpdateRequest) {
            return call2(listUpdateOperation, listUpdateRequest);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ListUpdateOperation call2(ListUpdateOperation listUpdateOperation, ListUpdateRequest listUpdateRequest) {
            AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
            ListUpdateRequest request = listUpdateOperation.getRequest();
            m.checkNotNullExpressionValue(listUpdateRequest, "nextUpdate");
            return anonymousClass1.invoke2(request, listUpdateRequest);
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<ListUpdateOperation, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ListUpdateOperation listUpdateOperation) {
            invoke2(listUpdateOperation);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ListUpdateOperation listUpdateOperation) {
            ChannelMembersListAdapter.access$setMemberList$p(ChannelMembersListAdapter.this, listUpdateOperation.getRequest().getRows());
            if (listUpdateOperation instanceof ListUpdateOperation.DiffUpdate) {
                ((ListUpdateOperation.DiffUpdate) listUpdateOperation).getDiffResult().dispatchUpdatesTo(ChannelMembersListAdapter.this);
            } else if (listUpdateOperation instanceof ListUpdateOperation.OverwriteUpdate) {
                ChannelMembersListAdapter.this.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "it");
            ChannelMembersListAdapter.access$setUpdatesSubscription$p(ChannelMembersListAdapter.this, subscription);
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    public static final class DiffUtilCallback extends DiffUtil.Callback {
        private final WidgetChannelMembersListViewModel.MemberList nextMemberList;
        private final WidgetChannelMembersListViewModel.MemberList prevMemberList;

        public DiffUtilCallback(WidgetChannelMembersListViewModel.MemberList memberList, WidgetChannelMembersListViewModel.MemberList memberList2) {
            m.checkNotNullParameter(memberList, "prevMemberList");
            m.checkNotNullParameter(memberList2, "nextMemberList");
            this.prevMemberList = memberList;
            this.nextMemberList = memberList2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return m.areEqual(this.prevMemberList.get(oldItemPosition), this.nextMemberList.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return m.areEqual(this.prevMemberList.get(oldItemPosition).getRowId(), this.nextMemberList.get(newItemPosition).getRowId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.nextMemberList.getSize();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.prevMemberList.getSize();
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    public static abstract class Item {
        private final Object rowId;
        private final ViewType type;

        /* compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class AddMember extends Item {
            private final String rowId;
            private final int title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AddMember(String str, @StringRes int i) {
                super(ViewType.ADD_MEMBER, str, null);
                m.checkNotNullParameter(str, "rowId");
                this.rowId = str;
                this.title = i;
            }

            public static /* synthetic */ AddMember copy$default(AddMember addMember, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = addMember.getRowId();
                }
                if ((i2 & 2) != 0) {
                    i = addMember.title;
                }
                return addMember.copy(str, i);
            }

            public final String component1() {
                return getRowId();
            }

            /* renamed from: component2, reason: from getter */
            public final int getTitle() {
                return this.title;
            }

            public final AddMember copy(String rowId, @StringRes int title) {
                m.checkNotNullParameter(rowId, "rowId");
                return new AddMember(rowId, title);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AddMember)) {
                    return false;
                }
                AddMember addMember = (AddMember) other;
                return m.areEqual(getRowId(), addMember.getRowId()) && this.title == addMember.title;
            }

            @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item
            public /* bridge */ /* synthetic */ Object getRowId() {
                return getRowId();
            }

            public final int getTitle() {
                return this.title;
            }

            public int hashCode() {
                String rowId = getRowId();
                return ((rowId != null ? rowId.hashCode() : 0) * 31) + this.title;
            }

            public String toString() {
                StringBuilder sbU = a.U("AddMember(rowId=");
                sbU.append(getRowId());
                sbU.append(", title=");
                return a.B(sbU, this.title, ")");
            }

            @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item
            public String getRowId() {
                return this.rowId;
            }
        }

        /* compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class Header extends Item {
            private final Type headerType;
            private final int memberCount;
            private final String rowId;

            /* compiled from: ChannelMembersListAdapter.kt */
            public enum Type {
                ONLINE,
                OFFLINE,
                GROUP_DM
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Header(String str, Type type, int i) {
                super(ViewType.HEADER, str, null);
                m.checkNotNullParameter(str, "rowId");
                m.checkNotNullParameter(type, "headerType");
                this.rowId = str;
                this.headerType = type;
                this.memberCount = i;
            }

            public static /* synthetic */ Header copy$default(Header header, String str, Type type, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = header.getRowId();
                }
                if ((i2 & 2) != 0) {
                    type = header.headerType;
                }
                if ((i2 & 4) != 0) {
                    i = header.memberCount;
                }
                return header.copy(str, type, i);
            }

            public final String component1() {
                return getRowId();
            }

            /* renamed from: component2, reason: from getter */
            public final Type getHeaderType() {
                return this.headerType;
            }

            /* renamed from: component3, reason: from getter */
            public final int getMemberCount() {
                return this.memberCount;
            }

            public final Header copy(String rowId, Type headerType, int memberCount) {
                m.checkNotNullParameter(rowId, "rowId");
                m.checkNotNullParameter(headerType, "headerType");
                return new Header(rowId, headerType, memberCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Header)) {
                    return false;
                }
                Header header = (Header) other;
                return m.areEqual(getRowId(), header.getRowId()) && m.areEqual(this.headerType, header.headerType) && this.memberCount == header.memberCount;
            }

            public final Type getHeaderType() {
                return this.headerType;
            }

            public final int getMemberCount() {
                return this.memberCount;
            }

            @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item
            public /* bridge */ /* synthetic */ Object getRowId() {
                return getRowId();
            }

            public int hashCode() {
                String rowId = getRowId();
                int iHashCode = (rowId != null ? rowId.hashCode() : 0) * 31;
                Type type = this.headerType;
                return ((iHashCode + (type != null ? type.hashCode() : 0)) * 31) + this.memberCount;
            }

            public String toString() {
                StringBuilder sbU = a.U("Header(rowId=");
                sbU.append(getRowId());
                sbU.append(", headerType=");
                sbU.append(this.headerType);
                sbU.append(", memberCount=");
                return a.B(sbU, this.memberCount, ")");
            }

            @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item
            public String getRowId() {
                return this.rowId;
            }
        }

        /* compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class JoinLeaveThread extends Item {
            private final boolean isThreadJoined;
            private final String rowId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public JoinLeaveThread(String str, boolean z2) {
                super(ViewType.JOIN_LEAVE_THREAD, str, null);
                m.checkNotNullParameter(str, "rowId");
                this.rowId = str;
                this.isThreadJoined = z2;
            }

            public static /* synthetic */ JoinLeaveThread copy$default(JoinLeaveThread joinLeaveThread, String str, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = joinLeaveThread.getRowId();
                }
                if ((i & 2) != 0) {
                    z2 = joinLeaveThread.isThreadJoined;
                }
                return joinLeaveThread.copy(str, z2);
            }

            public final String component1() {
                return getRowId();
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsThreadJoined() {
                return this.isThreadJoined;
            }

            public final JoinLeaveThread copy(String rowId, boolean isThreadJoined) {
                m.checkNotNullParameter(rowId, "rowId");
                return new JoinLeaveThread(rowId, isThreadJoined);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof JoinLeaveThread)) {
                    return false;
                }
                JoinLeaveThread joinLeaveThread = (JoinLeaveThread) other;
                return m.areEqual(getRowId(), joinLeaveThread.getRowId()) && this.isThreadJoined == joinLeaveThread.isThreadJoined;
            }

            @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item
            public /* bridge */ /* synthetic */ Object getRowId() {
                return getRowId();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                String rowId = getRowId();
                int iHashCode = (rowId != null ? rowId.hashCode() : 0) * 31;
                boolean z2 = this.isThreadJoined;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public final boolean isThreadJoined() {
                return this.isThreadJoined;
            }

            public String toString() {
                StringBuilder sbU = a.U("JoinLeaveThread(rowId=");
                sbU.append(getRowId());
                sbU.append(", isThreadJoined=");
                return a.O(sbU, this.isThreadJoined, ")");
            }

            @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item
            public String getRowId() {
                return this.rowId;
            }
        }

        /* compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class Member extends Item {
            private final String avatarUrl;
            private final boolean canDisplayStatusEmoji;
            private final Integer color;
            private final Long guildId;
            private final boolean isApplicationStreaming;
            private final boolean isBot;
            private final String name;
            private final String premiumSince;
            private final Presence presence;
            private final boolean showOwnerIndicator;
            private final Integer tagText;
            private final boolean tagVerified;
            private final int userFlags;
            private final long userId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Member(long j, Long l, String str, boolean z2, Integer num, boolean z3, Presence presence, @ColorInt Integer num2, String str2, boolean z4, String str3, boolean z5, boolean z6, int i) {
                super(ViewType.MEMBER, Long.valueOf(j), null);
                m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                this.userId = j;
                this.guildId = l;
                this.name = str;
                this.isBot = z2;
                this.tagText = num;
                this.tagVerified = z3;
                this.presence = presence;
                this.color = num2;
                this.avatarUrl = str2;
                this.showOwnerIndicator = z4;
                this.premiumSince = str3;
                this.isApplicationStreaming = z5;
                this.canDisplayStatusEmoji = z6;
                this.userFlags = i;
            }

            public static /* synthetic */ Member copy$default(Member member, long j, Long l, String str, boolean z2, Integer num, boolean z3, Presence presence, Integer num2, String str2, boolean z4, String str3, boolean z5, boolean z6, int i, int i2, Object obj) {
                return member.copy((i2 & 1) != 0 ? member.userId : j, (i2 & 2) != 0 ? member.guildId : l, (i2 & 4) != 0 ? member.name : str, (i2 & 8) != 0 ? member.isBot : z2, (i2 & 16) != 0 ? member.tagText : num, (i2 & 32) != 0 ? member.tagVerified : z3, (i2 & 64) != 0 ? member.presence : presence, (i2 & 128) != 0 ? member.color : num2, (i2 & 256) != 0 ? member.avatarUrl : str2, (i2 & 512) != 0 ? member.showOwnerIndicator : z4, (i2 & 1024) != 0 ? member.premiumSince : str3, (i2 & 2048) != 0 ? member.isApplicationStreaming : z5, (i2 & 4096) != 0 ? member.canDisplayStatusEmoji : z6, (i2 & 8192) != 0 ? member.userFlags : i);
            }

            /* renamed from: component1, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            /* renamed from: component10, reason: from getter */
            public final boolean getShowOwnerIndicator() {
                return this.showOwnerIndicator;
            }

            /* renamed from: component11, reason: from getter */
            public final String getPremiumSince() {
                return this.premiumSince;
            }

            /* renamed from: component12, reason: from getter */
            public final boolean getIsApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            /* renamed from: component13, reason: from getter */
            public final boolean getCanDisplayStatusEmoji() {
                return this.canDisplayStatusEmoji;
            }

            /* renamed from: component14, reason: from getter */
            public final int getUserFlags() {
                return this.userFlags;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component3, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsBot() {
                return this.isBot;
            }

            /* renamed from: component5, reason: from getter */
            public final Integer getTagText() {
                return this.tagText;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getTagVerified() {
                return this.tagVerified;
            }

            /* renamed from: component7, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* renamed from: component8, reason: from getter */
            public final Integer getColor() {
                return this.color;
            }

            /* renamed from: component9, reason: from getter */
            public final String getAvatarUrl() {
                return this.avatarUrl;
            }

            public final Member copy(long userId, Long guildId, String name, boolean isBot, Integer tagText, boolean tagVerified, Presence presence, @ColorInt Integer color, String avatarUrl, boolean showOwnerIndicator, String premiumSince, boolean isApplicationStreaming, boolean canDisplayStatusEmoji, int userFlags) {
                m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return new Member(userId, guildId, name, isBot, tagText, tagVerified, presence, color, avatarUrl, showOwnerIndicator, premiumSince, isApplicationStreaming, canDisplayStatusEmoji, userFlags);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Member)) {
                    return false;
                }
                Member member = (Member) other;
                return this.userId == member.userId && m.areEqual(this.guildId, member.guildId) && m.areEqual(this.name, member.name) && this.isBot == member.isBot && m.areEqual(this.tagText, member.tagText) && this.tagVerified == member.tagVerified && m.areEqual(this.presence, member.presence) && m.areEqual(this.color, member.color) && m.areEqual(this.avatarUrl, member.avatarUrl) && this.showOwnerIndicator == member.showOwnerIndicator && m.areEqual(this.premiumSince, member.premiumSince) && this.isApplicationStreaming == member.isApplicationStreaming && this.canDisplayStatusEmoji == member.canDisplayStatusEmoji && this.userFlags == member.userFlags;
            }

            public final String getAvatarUrl() {
                return this.avatarUrl;
            }

            public final boolean getCanDisplayStatusEmoji() {
                return this.canDisplayStatusEmoji;
            }

            public final Integer getColor() {
                return this.color;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final String getName() {
                return this.name;
            }

            public final String getPremiumSince() {
                return this.premiumSince;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final boolean getShowOwnerIndicator() {
                return this.showOwnerIndicator;
            }

            public final Integer getTagText() {
                return this.tagText;
            }

            public final boolean getTagVerified() {
                return this.tagVerified;
            }

            public final int getUserFlags() {
                return this.userFlags;
            }

            public final long getUserId() {
                return this.userId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iA = b.a(this.userId) * 31;
                Long l = this.guildId;
                int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
                String str = this.name;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.isBot;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                Integer num = this.tagText;
                int iHashCode3 = (i2 + (num != null ? num.hashCode() : 0)) * 31;
                boolean z3 = this.tagVerified;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode3 + i3) * 31;
                Presence presence = this.presence;
                int iHashCode4 = (i4 + (presence != null ? presence.hashCode() : 0)) * 31;
                Integer num2 = this.color;
                int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
                String str2 = this.avatarUrl;
                int iHashCode6 = (iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
                boolean z4 = this.showOwnerIndicator;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (iHashCode6 + i5) * 31;
                String str3 = this.premiumSince;
                int iHashCode7 = (i6 + (str3 != null ? str3.hashCode() : 0)) * 31;
                boolean z5 = this.isApplicationStreaming;
                int i7 = z5;
                if (z5 != 0) {
                    i7 = 1;
                }
                int i8 = (iHashCode7 + i7) * 31;
                boolean z6 = this.canDisplayStatusEmoji;
                return ((i8 + (z6 ? 1 : z6 ? 1 : 0)) * 31) + this.userFlags;
            }

            public final boolean isApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final boolean isBot() {
                return this.isBot;
            }

            public String toString() {
                StringBuilder sbU = a.U("Member(userId=");
                sbU.append(this.userId);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", name=");
                sbU.append(this.name);
                sbU.append(", isBot=");
                sbU.append(this.isBot);
                sbU.append(", tagText=");
                sbU.append(this.tagText);
                sbU.append(", tagVerified=");
                sbU.append(this.tagVerified);
                sbU.append(", presence=");
                sbU.append(this.presence);
                sbU.append(", color=");
                sbU.append(this.color);
                sbU.append(", avatarUrl=");
                sbU.append(this.avatarUrl);
                sbU.append(", showOwnerIndicator=");
                sbU.append(this.showOwnerIndicator);
                sbU.append(", premiumSince=");
                sbU.append(this.premiumSince);
                sbU.append(", isApplicationStreaming=");
                sbU.append(this.isApplicationStreaming);
                sbU.append(", canDisplayStatusEmoji=");
                sbU.append(this.canDisplayStatusEmoji);
                sbU.append(", userFlags=");
                return a.B(sbU, this.userFlags, ")");
            }
        }

        /* compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class PlaceholderHeader extends Item {
            private final String listId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PlaceholderHeader(String str) {
                super(ViewType.PLACEHOLDER_HEADER, a.w("placeholder:", str), null);
                m.checkNotNullParameter(str, "listId");
                this.listId = str;
            }

            public static /* synthetic */ PlaceholderHeader copy$default(PlaceholderHeader placeholderHeader, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = placeholderHeader.listId;
                }
                return placeholderHeader.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getListId() {
                return this.listId;
            }

            public final PlaceholderHeader copy(String listId) {
                m.checkNotNullParameter(listId, "listId");
                return new PlaceholderHeader(listId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof PlaceholderHeader) && m.areEqual(this.listId, ((PlaceholderHeader) other).listId);
                }
                return true;
            }

            public final String getListId() {
                return this.listId;
            }

            public int hashCode() {
                String str = this.listId;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.J(a.U("PlaceholderHeader(listId="), this.listId, ")");
            }
        }

        /* compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class PlaceholderMember extends Item {
            private final float placeholderSize;

            public PlaceholderMember(float f) {
                super(ViewType.LOADING, "", null);
                this.placeholderSize = f;
            }

            /* renamed from: component1, reason: from getter */
            private final float getPlaceholderSize() {
                return this.placeholderSize;
            }

            public static /* synthetic */ PlaceholderMember copy$default(PlaceholderMember placeholderMember, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = placeholderMember.placeholderSize;
                }
                return placeholderMember.copy(f);
            }

            public final PlaceholderMember copy(float placeholderSize) {
                return new PlaceholderMember(placeholderSize);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof PlaceholderMember) && Float.compare(this.placeholderSize, ((PlaceholderMember) other).placeholderSize) == 0;
                }
                return true;
            }

            public int hashCode() {
                return Float.floatToIntBits(this.placeholderSize);
            }

            public String toString() {
                StringBuilder sbU = a.U("PlaceholderMember(placeholderSize=");
                sbU.append(this.placeholderSize);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class RoleHeader extends Item {
            private final Long guildId;
            private final int memberCount;
            private final long roleId;
            private final String roleName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RoleHeader(long j, String str, int i, Long l) {
                super(ViewType.ROLE_HEADER, Long.valueOf(j), null);
                m.checkNotNullParameter(str, "roleName");
                this.roleId = j;
                this.roleName = str;
                this.memberCount = i;
                this.guildId = l;
            }

            public static /* synthetic */ RoleHeader copy$default(RoleHeader roleHeader, long j, String str, int i, Long l, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    j = roleHeader.roleId;
                }
                long j2 = j;
                if ((i2 & 2) != 0) {
                    str = roleHeader.roleName;
                }
                String str2 = str;
                if ((i2 & 4) != 0) {
                    i = roleHeader.memberCount;
                }
                int i3 = i;
                if ((i2 & 8) != 0) {
                    l = roleHeader.guildId;
                }
                return roleHeader.copy(j2, str2, i3, l);
            }

            /* renamed from: component1, reason: from getter */
            public final long getRoleId() {
                return this.roleId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getRoleName() {
                return this.roleName;
            }

            /* renamed from: component3, reason: from getter */
            public final int getMemberCount() {
                return this.memberCount;
            }

            /* renamed from: component4, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            public final RoleHeader copy(long roleId, String roleName, int memberCount, Long guildId) {
                m.checkNotNullParameter(roleName, "roleName");
                return new RoleHeader(roleId, roleName, memberCount, guildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RoleHeader)) {
                    return false;
                }
                RoleHeader roleHeader = (RoleHeader) other;
                return this.roleId == roleHeader.roleId && m.areEqual(this.roleName, roleHeader.roleName) && this.memberCount == roleHeader.memberCount && m.areEqual(this.guildId, roleHeader.guildId);
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final int getMemberCount() {
                return this.memberCount;
            }

            public final long getRoleId() {
                return this.roleId;
            }

            public final String getRoleName() {
                return this.roleName;
            }

            public int hashCode() {
                int iA = b.a(this.roleId) * 31;
                String str = this.roleName;
                int iHashCode = (((iA + (str != null ? str.hashCode() : 0)) * 31) + this.memberCount) * 31;
                Long l = this.guildId;
                return iHashCode + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("RoleHeader(roleId=");
                sbU.append(this.roleId);
                sbU.append(", roleName=");
                sbU.append(this.roleName);
                sbU.append(", memberCount=");
                sbU.append(this.memberCount);
                sbU.append(", guildId=");
                return a.G(sbU, this.guildId, ")");
            }
        }

        private Item(ViewType viewType, Object obj) {
            this.type = viewType;
            this.rowId = obj;
        }

        public Object getRowId() {
            return this.rowId;
        }

        public final ViewType getType() {
            return this.type;
        }

        public /* synthetic */ Item(ViewType viewType, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewType, obj);
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    public static abstract class ListUpdateOperation {
        private final ListUpdateRequest request;

        /* compiled from: ChannelMembersListAdapter.kt */
        public static final class DiffUpdate extends ListUpdateOperation {
            private final DiffUtil.DiffResult diffResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DiffUpdate(DiffUtil.DiffResult diffResult, ListUpdateRequest listUpdateRequest) {
                super(listUpdateRequest, null);
                m.checkNotNullParameter(diffResult, "diffResult");
                m.checkNotNullParameter(listUpdateRequest, "listUpdateRequest");
                this.diffResult = diffResult;
            }

            public final DiffUtil.DiffResult getDiffResult() {
                return this.diffResult;
            }
        }

        /* compiled from: ChannelMembersListAdapter.kt */
        public static final class OverwriteUpdate extends ListUpdateOperation {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OverwriteUpdate(ListUpdateRequest listUpdateRequest) {
                super(listUpdateRequest, null);
                m.checkNotNullParameter(listUpdateRequest, "listUpdateRequest");
            }
        }

        private ListUpdateOperation(ListUpdateRequest listUpdateRequest) {
            this.request = listUpdateRequest;
        }

        public final ListUpdateRequest getRequest() {
            return this.request;
        }

        public /* synthetic */ ListUpdateOperation(ListUpdateRequest listUpdateRequest, DefaultConstructorMarker defaultConstructorMarker) {
            this(listUpdateRequest);
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    public static final /* data */ class ListUpdateRequest {
        private final boolean forceOverwrite;
        private final String listId;
        private final WidgetChannelMembersListViewModel.MemberList rows;

        public ListUpdateRequest(String str, WidgetChannelMembersListViewModel.MemberList memberList, boolean z2) {
            m.checkNotNullParameter(str, "listId");
            m.checkNotNullParameter(memberList, "rows");
            this.listId = str;
            this.rows = memberList;
            this.forceOverwrite = z2;
        }

        public static /* synthetic */ ListUpdateRequest copy$default(ListUpdateRequest listUpdateRequest, String str, WidgetChannelMembersListViewModel.MemberList memberList, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = listUpdateRequest.listId;
            }
            if ((i & 2) != 0) {
                memberList = listUpdateRequest.rows;
            }
            if ((i & 4) != 0) {
                z2 = listUpdateRequest.forceOverwrite;
            }
            return listUpdateRequest.copy(str, memberList, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getListId() {
            return this.listId;
        }

        /* renamed from: component2, reason: from getter */
        public final WidgetChannelMembersListViewModel.MemberList getRows() {
            return this.rows;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getForceOverwrite() {
            return this.forceOverwrite;
        }

        public final ListUpdateRequest copy(String listId, WidgetChannelMembersListViewModel.MemberList rows, boolean forceOverwrite) {
            m.checkNotNullParameter(listId, "listId");
            m.checkNotNullParameter(rows, "rows");
            return new ListUpdateRequest(listId, rows, forceOverwrite);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListUpdateRequest)) {
                return false;
            }
            ListUpdateRequest listUpdateRequest = (ListUpdateRequest) other;
            return m.areEqual(this.listId, listUpdateRequest.listId) && m.areEqual(this.rows, listUpdateRequest.rows) && this.forceOverwrite == listUpdateRequest.forceOverwrite;
        }

        public final boolean getForceOverwrite() {
            return this.forceOverwrite;
        }

        public final String getListId() {
            return this.listId;
        }

        public final WidgetChannelMembersListViewModel.MemberList getRows() {
            return this.rows;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.listId;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            WidgetChannelMembersListViewModel.MemberList memberList = this.rows;
            int iHashCode2 = (iHashCode + (memberList != null ? memberList.hashCode() : 0)) * 31;
            boolean z2 = this.forceOverwrite;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("ListUpdateRequest(listId=");
            sbU.append(this.listId);
            sbU.append(", rows=");
            sbU.append(this.rows);
            sbU.append(", forceOverwrite=");
            return a.O(sbU, this.forceOverwrite, ")");
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    public static final class StickyHeadersManager {
        private View currentStickyHeaderView;
        private final WidgetChannelMembersListItemHeaderBinding headerViewBinding;
        private final ChannelMembersListViewHolderHeader onlineOfflineStickyHeader;
        private final WidgetChannelMembersListItemPlaceholderHeaderBinding placeholderHeaderViewBinding;
        private final ChannelMembersListViewHolderRoleHeader roleStickyHeader;

        public StickyHeadersManager(WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding, WidgetChannelMembersListItemPlaceholderHeaderBinding widgetChannelMembersListItemPlaceholderHeaderBinding) {
            m.checkNotNullParameter(widgetChannelMembersListItemHeaderBinding, "headerViewBinding");
            m.checkNotNullParameter(widgetChannelMembersListItemPlaceholderHeaderBinding, "placeholderHeaderViewBinding");
            this.headerViewBinding = widgetChannelMembersListItemHeaderBinding;
            this.placeholderHeaderViewBinding = widgetChannelMembersListItemPlaceholderHeaderBinding;
            this.roleStickyHeader = new ChannelMembersListViewHolderRoleHeader(widgetChannelMembersListItemHeaderBinding);
            this.onlineOfflineStickyHeader = new ChannelMembersListViewHolderHeader(widgetChannelMembersListItemHeaderBinding);
            this.currentStickyHeaderView = widgetChannelMembersListItemHeaderBinding.a;
        }

        public final void bindStickyHeaderView(Item row) {
            m.checkNotNullParameter(row, "row");
            if (row instanceof Item.RoleHeader) {
                this.roleStickyHeader.bind((Item.RoleHeader) row);
                this.currentStickyHeaderView = this.headerViewBinding.a;
                return;
            }
            if (row instanceof Item.Header) {
                this.onlineOfflineStickyHeader.bind((Item.Header) row);
                WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding = this.headerViewBinding;
                this.currentStickyHeaderView = widgetChannelMembersListItemHeaderBinding.a;
                RoleIconView roleIconView = widgetChannelMembersListItemHeaderBinding.f2259b;
                m.checkNotNullExpressionValue(roleIconView, "headerViewBinding.channe…ersListItemHeaderRoleIcon");
                roleIconView.setVisibility(8);
                return;
            }
            if (row instanceof Item.PlaceholderHeader) {
                this.currentStickyHeaderView = this.placeholderHeaderViewBinding.a;
                RoleIconView roleIconView2 = this.headerViewBinding.f2259b;
                m.checkNotNullExpressionValue(roleIconView2, "headerViewBinding.channe…ersListItemHeaderRoleIcon");
                roleIconView2.setVisibility(8);
                return;
            }
            if (row instanceof Item.AddMember) {
                this.currentStickyHeaderView = null;
                RoleIconView roleIconView3 = this.headerViewBinding.f2259b;
                m.checkNotNullExpressionValue(roleIconView3, "headerViewBinding.channe…ersListItemHeaderRoleIcon");
                roleIconView3.setVisibility(8);
            }
        }

        public final View getCurrentStickyHeaderView() {
            return this.currentStickyHeaderView;
        }

        public final void layoutViews(RecyclerView recyclerView) {
            m.checkNotNullParameter(recyclerView, "recyclerView");
            LinearLayout linearLayout = this.headerViewBinding.a;
            m.checkNotNullExpressionValue(linearLayout, "headerViewBinding.root");
            StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, linearLayout);
            FrameLayout frameLayout = this.placeholderHeaderViewBinding.a;
            m.checkNotNullExpressionValue(frameLayout, "placeholderHeaderViewBinding.root");
            StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, frameLayout);
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    public enum ViewType {
        ROLE_HEADER,
        PLACEHOLDER_HEADER,
        HEADER,
        MEMBER,
        ADD_MEMBER,
        LOADING,
        JOIN_LEAVE_THREAD;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ViewType[] cachedValues = values();

        /* compiled from: ChannelMembersListAdapter.kt */
        public static final class Companion {
            private Companion() {
            }

            public final ViewType fromOrdinal(int ordinal) {
                return ViewType.access$getCachedValues$cp()[ordinal];
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final /* synthetic */ ViewType[] access$getCachedValues$cp() {
            return cachedValues;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            Item.Header.Type.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[Item.Header.Type.ONLINE.ordinal()] = 1;
            iArr[Item.Header.Type.OFFLINE.ordinal()] = 2;
            iArr[Item.Header.Type.GROUP_DM.ordinal()] = 3;
            ViewType.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ViewType.HEADER.ordinal()] = 1;
            iArr2[ViewType.ROLE_HEADER.ordinal()] = 2;
            iArr2[ViewType.MEMBER.ordinal()] = 3;
            iArr2[ViewType.LOADING.ordinal()] = 4;
            iArr2[ViewType.PLACEHOLDER_HEADER.ordinal()] = 5;
            iArr2[ViewType.ADD_MEMBER.ordinal()] = 6;
            iArr2[ViewType.JOIN_LEAVE_THREAD.ordinal()] = 7;
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$onAttachedToRecyclerView$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLayoutChangeListener {
        public final /* synthetic */ RecyclerView $recyclerView;

        public AnonymousClass1(RecyclerView recyclerView) {
            this.$recyclerView = recyclerView;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ChannelMembersListAdapter.access$getStickyHeadersManager$p(ChannelMembersListAdapter.this).layoutViews(this.$recyclerView);
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$onBindViewHolder$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Item.Member $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Item.Member member) {
            super(0);
            this.$item = member;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function1 function1Access$getOnUserClicked$p = ChannelMembersListAdapter.access$getOnUserClicked$p(ChannelMembersListAdapter.this);
            if (function1Access$getOnUserClicked$p != null) {
            }
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$onBindViewHolder$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0 function0Access$getOnAddMemberClicked$p = ChannelMembersListAdapter.access$getOnAddMemberClicked$p(ChannelMembersListAdapter.this);
            if (function0Access$getOnAddMemberClicked$p != null) {
            }
        }
    }

    /* compiled from: ChannelMembersListAdapter.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$onBindViewHolder$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0 function0Access$getOnJoinLeaveThreadClicked$p = ChannelMembersListAdapter.access$getOnJoinLeaveThreadClicked$p(ChannelMembersListAdapter.this);
            if (function0Access$getOnJoinLeaveThreadClicked$p != null) {
            }
        }
    }

    public ChannelMembersListAdapter() {
        PublishSubject<ListUpdateRequest> publishSubjectK0 = PublishSubject.k0();
        this.updatesSubject = publishSubjectK0;
        WidgetChannelMembersListViewModel.MemberList empty = WidgetChannelMembersListViewModel.MemberList.INSTANCE.getEMPTY();
        this.memberList = empty;
        ListUpdateOperation.OverwriteUpdate overwriteUpdate = new ListUpdateOperation.OverwriteUpdate(new ListUpdateRequest("", empty, false));
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        m.checkNotNullExpressionValue(publishSubjectK0, "updatesSubject");
        Observable observableS = ObservableExtensionsKt.computationLatest(publishSubjectK0).Q(overwriteUpdate, AnonymousClass2.INSTANCE).S(1);
        m.checkNotNullExpressionValue(observableS, "updatesSubject\n        .…      })\n        .skip(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableS), ChannelMembersListAdapter.class, (Context) null, new AnonymousClass4(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 58, (Object) null);
    }

    public static final /* synthetic */ WidgetChannelMembersListViewModel.MemberList access$getMemberList$p(ChannelMembersListAdapter channelMembersListAdapter) {
        return channelMembersListAdapter.memberList;
    }

    public static final /* synthetic */ Function0 access$getOnAddMemberClicked$p(ChannelMembersListAdapter channelMembersListAdapter) {
        return channelMembersListAdapter.onAddMemberClicked;
    }

    public static final /* synthetic */ Function0 access$getOnJoinLeaveThreadClicked$p(ChannelMembersListAdapter channelMembersListAdapter) {
        return channelMembersListAdapter.onJoinLeaveThreadClicked;
    }

    public static final /* synthetic */ Function1 access$getOnUserClicked$p(ChannelMembersListAdapter channelMembersListAdapter) {
        return channelMembersListAdapter.onUserClicked;
    }

    public static final /* synthetic */ StickyHeadersManager access$getStickyHeadersManager$p(ChannelMembersListAdapter channelMembersListAdapter) {
        StickyHeadersManager stickyHeadersManager = channelMembersListAdapter.stickyHeadersManager;
        if (stickyHeadersManager == null) {
            m.throwUninitializedPropertyAccessException("stickyHeadersManager");
        }
        return stickyHeadersManager;
    }

    public static final /* synthetic */ Subscription access$getUpdatesSubscription$p(ChannelMembersListAdapter channelMembersListAdapter) {
        return channelMembersListAdapter.updatesSubscription;
    }

    public static final /* synthetic */ void access$setMemberList$p(ChannelMembersListAdapter channelMembersListAdapter, WidgetChannelMembersListViewModel.MemberList memberList) {
        channelMembersListAdapter.memberList = memberList;
    }

    public static final /* synthetic */ void access$setOnAddMemberClicked$p(ChannelMembersListAdapter channelMembersListAdapter, Function0 function0) {
        channelMembersListAdapter.onAddMemberClicked = function0;
    }

    public static final /* synthetic */ void access$setOnJoinLeaveThreadClicked$p(ChannelMembersListAdapter channelMembersListAdapter, Function0 function0) {
        channelMembersListAdapter.onJoinLeaveThreadClicked = function0;
    }

    public static final /* synthetic */ void access$setOnUserClicked$p(ChannelMembersListAdapter channelMembersListAdapter, Function1 function1) {
        channelMembersListAdapter.onUserClicked = function1;
    }

    public static final /* synthetic */ void access$setStickyHeadersManager$p(ChannelMembersListAdapter channelMembersListAdapter, StickyHeadersManager stickyHeadersManager) {
        channelMembersListAdapter.stickyHeadersManager = stickyHeadersManager;
    }

    public static final /* synthetic */ void access$setUpdatesSubscription$p(ChannelMembersListAdapter channelMembersListAdapter, Subscription subscription) {
        channelMembersListAdapter.updatesSubscription = subscription;
    }

    public final Unit dispose() {
        Subscription subscription = this.updatesSubscription;
        if (subscription == null) {
            return null;
        }
        subscription.unsubscribe();
        return Unit.a;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        Item item = this.memberList.get(position);
        try {
            try {
                StickyHeadersManager stickyHeadersManager = this.stickyHeadersManager;
                if (stickyHeadersManager == null) {
                    m.throwUninitializedPropertyAccessException("stickyHeadersManager");
                }
                stickyHeadersManager.bindStickyHeaderView(item);
                StickyHeadersManager stickyHeadersManager2 = this.stickyHeadersManager;
                if (stickyHeadersManager2 == null) {
                    m.throwUninitializedPropertyAccessException("stickyHeadersManager");
                }
                return stickyHeadersManager2.getCurrentStickyHeaderView();
            } catch (ClassCastException unused) {
                Logger.e$default(AppLog.g, "Failed to cast header", null, null, 6, null);
                StickyHeadersManager stickyHeadersManager3 = this.stickyHeadersManager;
                if (stickyHeadersManager3 == null) {
                    m.throwUninitializedPropertyAccessException("stickyHeadersManager");
                }
                return stickyHeadersManager3.getCurrentStickyHeaderView();
            }
        } catch (Throwable unused2) {
            StickyHeadersManager stickyHeadersManager4 = this.stickyHeadersManager;
            if (stickyHeadersManager4 == null) {
                m.throwUninitializedPropertyAccessException("stickyHeadersManager");
            }
            return stickyHeadersManager4.getCurrentStickyHeaderView();
        }
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public Integer getHeaderPositionForItem(int itemPosition) {
        return this.memberList.getHeaderPositionForItem(itemPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.memberList.getSize();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        Item item = this.memberList.get(position);
        if (item instanceof Item.Member) {
            return ((Item.Member) item).getUserId();
        }
        if (item instanceof Item.RoleHeader) {
            return ((Item.RoleHeader) item).getRoleId();
        }
        if ((item instanceof Item.AddMember) || (item instanceof Item.JoinLeaveThread)) {
            return -1L;
        }
        if (!(item instanceof Item.Header)) {
            if (item instanceof Item.PlaceholderHeader) {
                return -5L;
            }
            if (item instanceof Item.PlaceholderMember) {
                return (-1) * (position + 6);
            }
            throw new NoWhenBranchMatchedException();
        }
        int iOrdinal = ((Item.Header) item).getHeaderType().ordinal();
        if (iOrdinal == 0) {
            return -2L;
        }
        if (iOrdinal == 1) {
            return -3L;
        }
        if (iOrdinal == 2) {
            return -4L;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.memberList.get(position).getType().ordinal();
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public boolean isHeader(int position) {
        Item item = this.memberList.get(position);
        return (item instanceof Item.Header) || (item instanceof Item.RoleHeader) || (item instanceof Item.PlaceholderHeader);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBindingA = WidgetChannelMembersListItemHeaderBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        m.checkNotNullExpressionValue(widgetChannelMembersListItemHeaderBindingA, "WidgetChannelMembersList…View,\n        false\n    )");
        WidgetChannelMembersListItemPlaceholderHeaderBinding widgetChannelMembersListItemPlaceholderHeaderBindingA = WidgetChannelMembersListItemPlaceholderHeaderBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        m.checkNotNullExpressionValue(widgetChannelMembersListItemPlaceholderHeaderBindingA, "WidgetChannelMembersList…View,\n        false\n    )");
        this.stickyHeadersManager = new StickyHeadersManager(widgetChannelMembersListItemHeaderBindingA, widgetChannelMembersListItemPlaceholderHeaderBindingA);
        recyclerView.addOnLayoutChangeListener(new AnonymousClass1(recyclerView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        if (holder instanceof ChannelMembersListViewHolderHeader) {
            Item item = this.memberList.get(position);
            Objects.requireNonNull(item, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.Header");
            ((ChannelMembersListViewHolderHeader) holder).bind((Item.Header) item);
            return;
        }
        if (holder instanceof ChannelMembersListViewHolderMember) {
            Item item2 = this.memberList.get(position);
            Objects.requireNonNull(item2, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.Member");
            Item.Member member = (Item.Member) item2;
            ((ChannelMembersListViewHolderMember) holder).bind(member, new AnonymousClass1(member));
            return;
        }
        if (holder instanceof ChannelMembersListViewHolderLoading) {
            ((ChannelMembersListViewHolderLoading) holder).bind(position);
            return;
        }
        if (holder instanceof ChannelMembersListViewHolderRoleHeader) {
            Item item3 = this.memberList.get(position);
            Objects.requireNonNull(item3, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.RoleHeader");
            ((ChannelMembersListViewHolderRoleHeader) holder).bind((Item.RoleHeader) item3);
        } else if (holder instanceof ChannelMembersListViewHolderAdd) {
            Item item4 = this.memberList.get(position);
            Objects.requireNonNull(item4, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.AddMember");
            ((ChannelMembersListViewHolderAdd) holder).bind(new AnonymousClass2(), ((Item.AddMember) item4).getTitle());
        } else if (holder instanceof ChannelMembersListViewHolderJoinLeaveThread) {
            Item item5 = this.memberList.get(position);
            Objects.requireNonNull(item5, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.JoinLeaveThread");
            ((ChannelMembersListViewHolderJoinLeaveThread) holder).bind(new AnonymousClass3(), ((Item.JoinLeaveThread) item5).isThreadJoined());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        switch (ViewType.INSTANCE.fromOrdinal(viewType)) {
            case ROLE_HEADER:
                WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBindingA = WidgetChannelMembersListItemHeaderBinding.a(layoutInflaterFrom, parent, false);
                m.checkNotNullExpressionValue(widgetChannelMembersListItemHeaderBindingA, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderRoleHeader(widgetChannelMembersListItemHeaderBindingA);
            case PLACEHOLDER_HEADER:
                WidgetChannelMembersListItemPlaceholderHeaderBinding widgetChannelMembersListItemPlaceholderHeaderBindingA = WidgetChannelMembersListItemPlaceholderHeaderBinding.a(layoutInflaterFrom, parent, false);
                m.checkNotNullExpressionValue(widgetChannelMembersListItemPlaceholderHeaderBindingA, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderPlaceholderHeader(widgetChannelMembersListItemPlaceholderHeaderBindingA);
            case HEADER:
                WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBindingA2 = WidgetChannelMembersListItemHeaderBinding.a(layoutInflaterFrom, parent, false);
                m.checkNotNullExpressionValue(widgetChannelMembersListItemHeaderBindingA2, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderHeader(widgetChannelMembersListItemHeaderBindingA2);
            case MEMBER:
                View viewInflate = layoutInflaterFrom.inflate(R.layout.widget_channel_members_list_item_user, parent, false);
                int i = R.id.channel_members_list_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.channel_members_list_item_avatar);
                if (simpleDraweeView != null) {
                    i = R.id.channel_members_list_item_boosted_indicator;
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.channel_members_list_item_boosted_indicator);
                    if (imageView != null) {
                        i = R.id.channel_members_list_item_game;
                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) viewInflate.findViewById(R.id.channel_members_list_item_game);
                        if (simpleDraweeSpanTextView != null) {
                            i = R.id.channel_members_list_item_group_owner_indicator;
                            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.channel_members_list_item_group_owner_indicator);
                            if (imageView2 != null) {
                                i = R.id.channel_members_list_item_name;
                                UsernameView usernameView = (UsernameView) viewInflate.findViewById(R.id.channel_members_list_item_name);
                                if (usernameView != null) {
                                    i = R.id.channel_members_list_item_presence;
                                    StatusView statusView = (StatusView) viewInflate.findViewById(R.id.channel_members_list_item_presence);
                                    if (statusView != null) {
                                        i = R.id.channel_members_list_item_rich_presence_iv;
                                        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.channel_members_list_item_rich_presence_iv);
                                        if (imageView3 != null) {
                                            WidgetChannelMembersListItemUserBinding widgetChannelMembersListItemUserBinding = new WidgetChannelMembersListItemUserBinding((ConstraintLayout) viewInflate, simpleDraweeView, imageView, simpleDraweeSpanTextView, imageView2, usernameView, statusView, imageView3);
                                            m.checkNotNullExpressionValue(widgetChannelMembersListItemUserBinding, "WidgetChannelMembersList…(inflater, parent, false)");
                                            return new ChannelMembersListViewHolderMember(widgetChannelMembersListItemUserBinding);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
            case ADD_MEMBER:
                WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBindingA = WidgetChannelMembersListItemAddOrLeaveBinding.a(layoutInflaterFrom, parent, false);
                m.checkNotNullExpressionValue(widgetChannelMembersListItemAddOrLeaveBindingA, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderAdd(widgetChannelMembersListItemAddOrLeaveBindingA);
            case LOADING:
                View viewInflate2 = layoutInflaterFrom.inflate(R.layout.widget_channel_members_list_item_loading, parent, false);
                int i2 = R.id.blank_item_avatar_placeholder;
                View viewFindViewById = viewInflate2.findViewById(R.id.blank_item_avatar_placeholder);
                if (viewFindViewById != null) {
                    i2 = R.id.blank_item_username_placeholder;
                    View viewFindViewById2 = viewInflate2.findViewById(R.id.blank_item_username_placeholder);
                    if (viewFindViewById2 != null) {
                        i2 = R.id.username_placeholder_end_guideline;
                        Guideline guideline = (Guideline) viewInflate2.findViewById(R.id.username_placeholder_end_guideline);
                        if (guideline != null) {
                            WidgetChannelMembersListItemLoadingBinding widgetChannelMembersListItemLoadingBinding = new WidgetChannelMembersListItemLoadingBinding((ConstraintLayout) viewInflate2, viewFindViewById, viewFindViewById2, guideline);
                            m.checkNotNullExpressionValue(widgetChannelMembersListItemLoadingBinding, "WidgetChannelMembersList…(inflater, parent, false)");
                            return new ChannelMembersListViewHolderLoading(widgetChannelMembersListItemLoadingBinding);
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
            case JOIN_LEAVE_THREAD:
                WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBindingA2 = WidgetChannelMembersListItemAddOrLeaveBinding.a(layoutInflaterFrom, parent, false);
                m.checkNotNullExpressionValue(widgetChannelMembersListItemAddOrLeaveBindingA2, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderJoinLeaveThread(widgetChannelMembersListItemAddOrLeaveBindingA2);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void setData(String listId, WidgetChannelMembersListViewModel.MemberList rows, boolean forceOverwrite) {
        m.checkNotNullParameter(listId, "listId");
        m.checkNotNullParameter(rows, "rows");
        PublishSubject<ListUpdateRequest> publishSubject = this.updatesSubject;
        publishSubject.k.onNext(new ListUpdateRequest(listId, rows, forceOverwrite));
    }

    public final void setOnAddMemberClicked(Function0<Unit> addMember) {
        m.checkNotNullParameter(addMember, "addMember");
        this.onAddMemberClicked = addMember;
    }

    public final void setOnJoinLeaveThreadClicked(Function0<Unit> joinLeaveThread) {
        m.checkNotNullParameter(joinLeaveThread, "joinLeaveThread");
        this.onJoinLeaveThreadClicked = joinLeaveThread;
    }

    public final void setOnUserClicked(Function1<? super Long, Unit> onUserClicked) {
        this.onUserClicked = onUserClicked;
    }
}
