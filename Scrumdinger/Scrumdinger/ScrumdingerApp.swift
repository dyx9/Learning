//
//  ScrumdingerApp.swift
//  Scrumdinger
//
//  Created by Yixuan Dai on 20/03/2024.
//

import SwiftUI

@main
struct ScrumdingerApp: App {
    var body: some Scene {
        WindowGroup {
            ScrumsView(scrums: DailyScrum.sampleData)
        }
    }
}
