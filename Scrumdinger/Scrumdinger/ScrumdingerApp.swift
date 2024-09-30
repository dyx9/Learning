//
//  ScrumdingerApp.swift
//  Scrumdinger
//
//  Created by Yixuan Dai on 20/03/2024.
//

import SwiftUI

@main
struct ScrumdingerApp: App {
    @State private var scrums = DailyScrum.sampleData
    var body: some Scene {
        WindowGroup {
            ScrumsView(scrums: $scrums)
        }
    }
}
