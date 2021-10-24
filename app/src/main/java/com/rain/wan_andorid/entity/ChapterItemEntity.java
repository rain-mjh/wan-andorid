package com.rain.wan_andorid.entity;

import java.util.List;


public class ChapterItemEntity {

    private DataBean data;
    private Integer errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        private Integer curPage;
        private List<DatasBean> datas;
        private Integer offset;
        private Boolean over;
        private Integer pageCount;
        private Integer size;
        private Integer total;

        public Integer getCurPage() {
            return curPage;
        }

        public void setCurPage(Integer curPage) {
            this.curPage = curPage;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Boolean getOver() {
            return over;
        }

        public void setOver(Boolean over) {
            this.over = over;
        }

        public Integer getPageCount() {
            return pageCount;
        }

        public void setPageCount(Integer pageCount) {
            this.pageCount = pageCount;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public static class DatasBean {
            private String apkLink;
            private Integer audit;
            private String author;
            private Boolean canEdit;
            private Integer chapterId;
            private String chapterName;
            private Boolean collect;
            private Integer courseId;
            private String desc;
            private String descMd;
            private String envelopePic;
            private Boolean fresh;
            private String host;
            private Integer id;
            private String link;
            private String niceDate;
            private String niceShareDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private Long publishTime;
            private Integer realSuperChapterId;
            private Integer selfVisible;
            private Long shareDate;
            private String shareUser;
            private Integer superChapterId;
            private String superChapterName;
            private List<TagsBean> tags;
            private String title;
            private Integer type;
            private Integer userId;
            private Integer visible;
            private Integer zan;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public Integer getAudit() {
                return audit;
            }

            public void setAudit(Integer audit) {
                this.audit = audit;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public Boolean getCanEdit() {
                return canEdit;
            }

            public void setCanEdit(Boolean canEdit) {
                this.canEdit = canEdit;
            }

            public Integer getChapterId() {
                return chapterId;
            }

            public void setChapterId(Integer chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public Boolean getCollect() {
                return collect;
            }

            public void setCollect(Boolean collect) {
                this.collect = collect;
            }

            public Integer getCourseId() {
                return courseId;
            }

            public void setCourseId(Integer courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDescMd() {
                return descMd;
            }

            public void setDescMd(String descMd) {
                this.descMd = descMd;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public Boolean getFresh() {
                return fresh;
            }

            public void setFresh(Boolean fresh) {
                this.fresh = fresh;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getNiceShareDate() {
                return niceShareDate;
            }

            public void setNiceShareDate(String niceShareDate) {
                this.niceShareDate = niceShareDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public Long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(Long publishTime) {
                this.publishTime = publishTime;
            }

            public Integer getRealSuperChapterId() {
                return realSuperChapterId;
            }

            public void setRealSuperChapterId(Integer realSuperChapterId) {
                this.realSuperChapterId = realSuperChapterId;
            }

            public Integer getSelfVisible() {
                return selfVisible;
            }

            public void setSelfVisible(Integer selfVisible) {
                this.selfVisible = selfVisible;
            }

            public Long getShareDate() {
                return shareDate;
            }

            public void setShareDate(Long shareDate) {
                this.shareDate = shareDate;
            }

            public String getShareUser() {
                return shareUser;
            }

            public void setShareUser(String shareUser) {
                this.shareUser = shareUser;
            }

            public Integer getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(Integer superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Integer getType() {
                return type;
            }

            public void setType(Integer type) {
                this.type = type;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public Integer getVisible() {
                return visible;
            }

            public void setVisible(Integer visible) {
                this.visible = visible;
            }

            public Integer getZan() {
                return zan;
            }

            public void setZan(Integer zan) {
                this.zan = zan;
            }

            public static class TagsBean {
                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
