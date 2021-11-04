package edu.xww.db.service;

import edu.xww.db.model.ContentPage;

import java.util.List;

public interface ContentPageService extends BaseService<ContentPage> {
    List<ContentPage> selectAllContentPageWithBlobs();
}
