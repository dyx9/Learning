//
//  ContentView.swift
//  FriendsFavouriteMovies
//
//  Created by Yixuan Dai on 07/05/2024.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        TabView {
            FilteredMovieList()
                .tabItem {
                    Label("Movies", systemImage: "film.stack")
                }
            
            FriendList()
                .tabItem {
                    Label("Friends", systemImage: "person.and.person")
                }
        }
    }
}

#Preview {
    ContentView()
        .modelContainer(SampleData.shared.modelContainer)
}
